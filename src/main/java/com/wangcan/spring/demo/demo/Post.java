package com.wangcan.spring.demo.demo;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

//@Data
//@ToString
//@Builder
//@NoArgsConstructor

public class Post {
    private Long id;
    private String title;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Post(Long id, String title, String content) {
                this.id = id;
                this.title = title;
                this.content = content;
        }


        public static <T> PostBuilder<T> builder() {
                return new PostBuilder<T>();
        }


        public static class PostBuilder<T> {
                private Long id;
    			private String title;
    			private String content;


                private PostBuilder() {}


                public PostBuilder id(Long id) {
                        this.id = id;
                        return this;
                }


                public PostBuilder title(String title) {
                        this.title = title;
                        return this;
                }
                public PostBuilder content(String content) {
                        this.content = content;
                        return this;
                }


                @java.lang.Override
                public String toString() {
                        return "PostBuilder(id = " + id + ", title = " + title + ", content = " + content + ")";
                }


                public Post build() {
                        return new Post(id, title, content);
                }
        }


}
