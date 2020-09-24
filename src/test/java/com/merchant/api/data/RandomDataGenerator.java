package com.merchant.api.data;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

public class RandomDataGenerator {
	
	private static final AtomicLong seedLong = new AtomicLong(Instant.now().toEpochMilli());

	public static User getUser() {
		long id = seedLong.incrementAndGet();
		User user = new User("user" + id, "first" + id, "last" + id);
		return user;
	}

	public static Post getPost(User user) {
		long id = seedLong.incrementAndGet();
		Post post = new Post(user.getId(), "title " + id, "body " + id);
		return post;
	}

	public static Comment getComment(User user, Post post) {
		long id = seedLong.incrementAndGet();
		Comment comment = new Comment(post.getId(), user.getId(), "body " + id);
		return comment;
	}

	private synchronized static String getId() {
		return String.valueOf(Instant.now().toEpochMilli());
	}
}
