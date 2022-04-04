-- Create dummy persons
INSERT INTO persons (id, name) VALUES (1, 'John Doe');
INSERT INTO persons (id, name) VALUES (2, 'Gandalf The Grey');
INSERT INTO persons (id, name) VALUES (3, 'Emmett Brown');

-- Create dummy posts for the dummy persons
INSERT INTO posts (id, title, person_id) VALUES (1, 'Where is my dog?', 1);
INSERT INTO posts (id, title, person_id) VALUES (2, 'You shall not pass!', 2);
INSERT INTO posts (id, title, person_id) VALUES (3, 'The way I see it, if you´re gonna build a time machine into a car, why not do it with some style?', 3);
INSERT INTO posts (id, title, person_id) VALUES (4, 'I’m sure that in 1985, plutonium is available at every corner drugstore, but in 1955 it’s a little hard to come by.', 3);