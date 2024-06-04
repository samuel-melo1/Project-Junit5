package br.com.samuel.apijunit5.repositories;

import br.com.samuel.apijunit5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
