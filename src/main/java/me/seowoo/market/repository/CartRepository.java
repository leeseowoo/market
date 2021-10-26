package me.seowoo.market.repository;

import me.seowoo.market.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findCartsByMemberId(long memberId);

    Optional<Cart> findByMemberIdAndProductId(long memberId, int productId);

    Cart findCartById(int cartId);

    @Transactional
    void deleteAllByMemberId(long memberId);
}
