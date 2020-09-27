package com.merchant.api.data;

import com.github.javafaker.Faker;

public class RandomDataGenerator {
		
	private static final Faker faker = new Faker();	


	public static User getUser() {
		return new User(faker.superhero().prefix() + faker.name().firstName() + faker.address().buildingNumber(),
				faker.name().firstName(), faker.name().lastName());
		
	}

	public static Post getPost(User user) {
		return new Post(user.getId(), faker.lorem().sentence(), faker.lorem().sentence());
	}

	public static Comment getComment(User user, Post post) {
		return new Comment(post.getId(), user.getId(), faker.lorem().sentence());
	}

}
