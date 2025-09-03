-- tag-based relation
CREATE TABLE course_tags (
    course_id BIGINT NOT NULL,
    tag_id BIGINT NOT NULL,
    PRIMARY KEY (course_id, tag_id),
    FOREIGN KEY (course_id) REFERENCES courses(id),
    FOREIGN KEY (tag_id) REFERENCES tags(id)
);

CREATE TABLE blog_tags (
    blog_id BIGINT NOT NULL,
    tag_id BIGINT NOT NULL,
    PRIMARY KEY (blog_id, tag_id),
    FOREIGN KEY (blog_id) REFERENCES blogs(id),
    FOREIGN KEY (tag_id) REFERENCES tags(id)
);

CREATE TABLE job_tags (
    job_id BIGINT NOT NULL,
    tag_id BIGINT NOT NULL,
    PRIMARY KEY (job_id, tag_id),
    FOREIGN KEY (job_id) REFERENCES jobs(id),
    FOREIGN KEY (tag_id) REFERENCES tags(id)
);

--category-based relation
CREATE TABLE content_categories (
    content_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (content_id, category_id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE course_categories (
    course_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (course_id, category_id),
    FOREIGN KEY (course_id) REFERENCES courses(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE blog_categories (
    blog_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (blog_id, category_id),
    FOREIGN KEY (blog_id) REFERENCES blogs(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE job_categories (
    job_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (job_id, category_id),
    FOREIGN KEY (job_id) REFERENCES jobs(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);