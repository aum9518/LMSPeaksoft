insert into users (role, id, email, first_name, last_name, password, phone_number)
values ('ADMIN', 1, 'admin@gmail.com', 'Manas', 'Abdugani uulu', 'Admin123', '+996221010101'),
       ('INSTRUCTOR', 2, 'ariana@gmail.com', 'Ariana', 'Grande', 'Ariana123', '+996221010101'),
       ('STUDENT', 3, 'jim@gmail.com', 'Jim', 'Carry', 'jim123', '+996221010101'),
       ('INSTRUCTOR', 4, 'charlie@gmail.com', 'Charlie', 'Path', 'Charlie123', '+996221010101');


insert into instructors(id, occupation, user_id)
VALUES (1, 'INSTRUCTOR', 2),
       (2, 'INSTRUCTOR', 4);

insert into groups(create_date, id, instructor_id, description, group_name, image)
VALUES (now(), 1, 1, 'Backend', 'Java-9', 'groups photo'),
       (now(), 2, 2, 'Frontend', 'JavaScript-9', 'groups photo');

insert into students(format, group_id, id, user_id)
VALUES (null, null, 1, 3);

insert into courses(date, duration, id, instructor_id, course_name, description, image)
VALUES (now(), '12-12-2023', 1, 1, 'Java', 'Backend', 'course photo');

insert into lessons(course_id, id, lesson_name) VALUES
                                                    (1,1,'Array'),
                                                    (1,2,'Loop');

insert into presentations(id, lesson_id, description, file, name) VALUES
                                                                      (1,1,'Arrays explanation',null,'Array'),
                                                                      (2,2,'Loop explanation',null,'Loop');
insert into video_lessons(id, lesson_id, description, link, name) VALUES
                                                                      (1,1,'Array','link lesson','Lesson'),
                                                                      (2,2,'Loop','link lesson','Lesson');
insert into tasks(id, lesson_id, code, description, image, task_name) VALUES
                                                                          (1,1,'Task code','add objects to array','photo','Array'),
                                                                          (2,2,'Task code','find objects by loops','photo','Loop');
insert into links(id, lesson_id, link, text) VALUES
                                                 (1,1,'Link to information','Array'),
                                                 (2,2,'Link to information','Loop');
