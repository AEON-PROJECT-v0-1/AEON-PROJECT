package com.aeon.project.services;

import com.aeon.project.commons.PostPrincipal;
import com.aeon.project.entities.Post;

public interface PostService {
	PostPrincipal findPostAddress(String postNo);

}
