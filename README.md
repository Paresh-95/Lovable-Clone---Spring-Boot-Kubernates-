# Lovable Clone Project

An AI-powered app builder inspired by [Lovable](https://lovable.dev). A user describes an app in a prompt, an LLM generates the code, the content is streamed back live, and the generated project runs in its own Kubernetes pod with a shareable preview URL.

Built with **Spring Boot**, **Spring Cloud**, and **Kubernetes**.

---

## How It Works

```
User ──prompt──▶ Server ──(system prompt)──▶ LLM
 ▲                 │  ▲                        │
 │                 │  └──────── content ───────┘
 │◀── stream ──────┘
 │                 │
 │                 ▼
 └── preview url ─ Kubernetes
```

1. The user sends a prompt.
2. The server adds a system prompt and forwards it to the LLM.
3. The generated content is streamed back to the user.
4. The generated project is deployed on Kubernetes and a preview URL is returned.

---

## Architecture

| Component | Responsibility |
|---|---|
| **Spring Cloud API Gateway** | Single entry point for all user requests; returns responses via SSE |
| **intelligence-service** | Builds the LLM request (system prompt + past 10 chat messages as session history), exposes tools (`list_files`, `get_file_content`), streams generated content, buffers and stores files |
| **workspace-service** | Manages project workspaces |
| **chat-service** | Manages chat sessions and message history |
| **execution-service** | Consumes `code.generated` events and runs each project in a new Kubernetes namespace |
| **LLM** | Generates code from prompts |
| **Qdrant Vector DB (RAG)** | Stores the codebase: code is chunked, embedded, and ingested; used for similarity search to give the LLM relevant context |
| **MinIO Storage** | Object storage for generated project files (e.g. `index.html`) |
| **Kafka** | Event bus — publishes the `code.generated` event |
| **Kubernetes** | Runs each project as an independent pod (e.g. `project-456:3000`), exposed to the user through an ingress + service |

### Generation Flow

1. **User → API Gateway → intelligence-service** with a prompt.
2. intelligence-service gathers context: system prompt, the last 10 chat messages, and similar code from Qdrant (RAG).
3. The **LLM** generates code, calling tools like `list_files` and `get_file_content` when needed.
4. Content is streamed back to the user over **SSE** (e.g. `file created: index.html`, `content added: ...`).
5. The content is buffered and stored as files in **MinIO**; the codebase is chunked, embedded, and ingested into **Qdrant**.
6. A `code.generated` event is published to **Kafka**.
7. **execution-service** picks up the event and spins up the project in a new namespace on Kubernetes.
8. The user opens the live preview through the **ingress + service**.

### Code Execution Options

- **WebContainer** — runs the project (`package.json`, `node_modules`, `index.html`, `App.js`, `vite.config.js`, ...) in the browser.
- **Micro VM / Independent Pod** — runs each project in an isolated pod on the cluster.

---

## Features

### Core Features

**Auth**
- Login
- Sign up
- Get my profile

**Projects**
- Create project, manage project
- List projects

**AI Code Generation**
- List chat sessions
- Create new chat session
- Load full chat history
- Chat stream
- Retry if failed

**Files**
- Get file tree + metadata
- Get file content
- Download all files as a zip

**Preview**
- Get project preview
- Get logs stream

### Additional Features

- **Payment** — Stripe
- **Quota management**
  - Plans: `FREE` | `PRO`
  - Token usage quota, running previews quota
- **Rate limiting** (via Redis)
- **Zipkin tracing**
- **Members** — one project can have many users

---

## Database Design

| Table | Description |
|---|---|
| `users` | Registered users (email, password hash, name, avatar, auth provider, Stripe customer id) |
| `plan` | Subscription plans with limits (max projects, max tokens per day, max previews, unlimited AI flag, features) |
| `subscription` | A user's active plan, Stripe subscription id, status, and billing period |
| `usage_log` | Per-user, per-project usage: action, tokens used, duration, metadata |
| `project` | Projects (name, description, owner, public flag, thumbnail) |
| `project_member` | Users belonging to a project with a role (`OWNER`, `EDITOR`, `VIEWER`) |
| `project_file` | Project files: path and MinIO object key |
| `preview` | Running previews: namespace, pod name, preview URL, status, start/end time |
| `chat_session` | Chat sessions per project and user |
| `chat_message` | Messages in a session: role (user / assistant / system / tool), content, tool calls, tokens used |

**Relationships**
- A user **owns** many projects and **is a member of** many projects.
- A user **has one active** subscription, which **follows** a plan.
- A user **performs** many usage logs.
- A project **has** many members, files, and chat sessions, and **has one active** preview.
- A chat session **contains** many chat messages.
