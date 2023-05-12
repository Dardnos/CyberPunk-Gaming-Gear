package no.ntnu.webshop.group12.webshop.repository;

import java.util.Optional;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

import no.ntnu.webshop.group12.webshop.models.QUser;
import no.ntnu.webshop.group12.webshop.models.User;

public interface UserRepository
        extends CrudRepository<User, Integer>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser>{
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameIgnoreCase(String username);

    @Override
    default void customize(QuerydslBindings binder, QUser root) {
        binder.bind(root.username).first((path, value) -> path.equalsIgnoreCase(value));
        binder.bind(root.active).first((path, value) -> path.eq(value));
        binder.excluding(root.password);
        binder.bind(root.purchases);
        binder.bind(root.cart);
    }
}
