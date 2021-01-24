package com.smartchoice.product.repository;

import com.smartchoice.product.entity.Content;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
