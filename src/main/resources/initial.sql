
INSERT INTO BOOKMARK(DTYPE, DESCRIPTION, TITLE, URL) VALUES('BlogBookmark', 'Language-agnostic practice problems and well-explained solutions.', 'Programming proficiency', 'proficient.blogspot.com'); 
INSERT INTO BOOKMARK(DTYPE, DESCRIPTION, TITLE, URL) VALUES('BlogBookmark', 'Daily frustrations and joys of an anonymous game developer.', 'Tales from Game Development', 'gameblog.com');
INSERT INTO BOOKMARK(DTYPE, DESCRIPTION, TITLE, URL) VALUES('OtherBookmark', 'Type: twitch channel. An open-source contributor streams her coding sessions.', 'CodeMazter', 'twitch.tv/CodeMazter'); 
INSERT INTO BOOKMARK(DTYPE, DESCRIPTION, TITLE, ISBN, AUTHOR) VALUES('BookBookmark', 'Clear examples of important design patterns.', 'Patterns of Enterprise Application Architecture', '978-0-321-12742-6', 'Fowler, Martin');
INSERT INTO BOOKMARK(DTYPE, DESCRIPTION, TITLE, ISBN, AUTHOR) VALUES('BookBookmark', 'Clear examples of important design patterns.', 'The Zen of Golf', '936-0-321-12742-6', 'Artisan, Adolf');

INSERT INTO TAG(name) VALUES ('design patterns'); 
INSERT INTO TAG(name) VALUES ('hobbies');

INSERT INTO BOOKMARK_TAGS VALUES(1,1);
INSERT INTO BOOKMARK_TAGS VALUES(4,1);
INSERT INTO BOOKMARK_TAGS VALUES(5,2);  