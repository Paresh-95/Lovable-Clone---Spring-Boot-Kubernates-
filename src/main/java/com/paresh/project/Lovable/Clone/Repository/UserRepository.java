package com.paresh.project.Lovable.Clone.Repository;

import com.paresh.project.Lovable.Clone.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
