insert into users (password, first_name, last_name, email, is_contributor, is_admin) values ('lorem', 'Jasmin', 'Sorel', 'jsorel0@usgs.gov', false, false);
insert into users (password, first_name, last_name, email, is_contributor, is_admin) values ('in', 'Marnie', 'Crimpe', 'mcrimpe1@opera.com', true, true);
insert into users (password, first_name, last_name, email, is_contributor, is_admin) values ('tempus', 'Melantha', 'Burness', 'mburness2@creativecommons.org', true, false);
insert into users (password, first_name, last_name, email, is_contributor, is_admin) values ('cum', 'Ward', 'D''Errico', 'wderrico3@japanpost.jp', true, false);
insert into users (password, first_name, last_name, email, is_contributor, is_admin) values ('curabitur', 'Saidee', 'Butter', 'sbutter4@xing.com', true, true);
insert into users (password, first_name, last_name, email, is_contributor, is_admin) values ('consequat', 'Jeffy', 'Davey', 'jdavey5@clickbank.net', true, true);
insert into users (password, first_name, last_name, email, is_contributor, is_admin) values ('aenean', 'Madel', 'McAuliffe', 'mmcauliffe6@howstuffworks.com', false, false);
insert into users (password, first_name, last_name, email, is_contributor, is_admin) values ('sed', 'Kelcey', 'Brashaw', 'kbrashaw7@netscape.com', false, true);
insert into users (password, first_name, last_name, email, is_contributor, is_admin) values ('elit', 'Dyann', 'Keilty', 'dkeilty8@twitpic.com', false, true);
insert into users (password, first_name, last_name, email, is_contributor, is_admin) values ('dui', 'Lula', 'Dunsire', 'ldunsire9@statcounter.com', false, false);

insert into addresses (address_line1, postal_code, city, country) values ('418 Independence Alley', 1182, 'Huangma', 'China');
insert into addresses (address_line1, postal_code, city, country) values ('76652 8th Center', 4982, 'Radzyń Chełmiński', 'Poland');
insert into addresses (address_line1, postal_code, city, country) values ('6 Hazelcrest Parkway', 1063, 'Ribafria', 'Portugal');
insert into addresses (address_line1, postal_code, city, country) values ('624 Maywood Crossing', 388, 'Hufang', 'China');
insert into addresses (address_line1, postal_code, city, country) values ('30077 Gale Lane', 8369, 'Sambongmulyo', 'Indonesia');
insert into addresses (address_line1, postal_code, city, country) values ('93752 Straubel Trail', 9567, 'Waśniów', 'Poland');
insert into addresses (address_line1, postal_code, city, country) values ('78 Stuart Terrace', 5279, 'Titiakar', 'Indonesia');
insert into addresses (address_line1, postal_code, city, country) values ('17 Declaration Terrace', 2900, 'Besuk Selatan', 'Indonesia');
insert into addresses (address_line1, postal_code, city, country) values ('6403 Norway Maple Lane', 8717, 'Tangxi', 'China');
insert into addresses (address_line1, postal_code, city, country) values ('373 Park Meadow Avenue', 4182, 'Miaoshi', 'China');


insert into profiles (weight, height, medical_conditions, disabilities, user_id, address_id) values (65, 17, 'pede', 'in', 1, 1);
insert into profiles (weight, height, medical_conditions, disabilities, user_id, address_id) values (13, 49, null, null, 2, 2);
insert into profiles (weight, height, medical_conditions, disabilities, user_id, address_id) values (81, 5, 'in', 'elit', 3, 3);
insert into profiles (weight, height, medical_conditions, disabilities, user_id, address_id) values (93, 92, null, null, 4, 4);
insert into profiles (weight, height, medical_conditions, disabilities, user_id, address_id) values (57, 70, null, null, 5, 5);
insert into profiles (weight, height, medical_conditions, disabilities, user_id, address_id) values (97, 64, null, null, 6, 6);
insert into profiles (weight, height, medical_conditions, disabilities, user_id, address_id) values (33, 73, null, null, 7, 7);
insert into profiles (weight, height, medical_conditions, disabilities, user_id, address_id) values (16, 82, 'congue', 'dui', 8, 8);
insert into profiles (weight, height, medical_conditions, disabilities, user_id, address_id) values (42, 59, null, null, 9, 9);
insert into profiles (weight, height, medical_conditions, disabilities, user_id, address_id) values (24, 78, null, null, 10, 10);


insert into workouts (name, type, complete, profile_id) values ('orci', 'quam', true, 1);
insert into workouts (name, type, complete, profile_id) values ('ipsum', 'potenti', true, 1);
insert into workouts (name, type, complete, profile_id) values ('orci', 'at', true,2);
insert into workouts (name, type, complete, profile_id) values ('eu', 'ante', false,3);
insert into workouts (name, type, complete, profile_id) values ('id', 'parturient', true,4);
insert into workouts (name, type, complete, profile_id) values ('libero', 'ipsum', false,5);
insert into workouts (name, type, complete, profile_id) values ('vestibulum', 'ac', false,10);
insert into workouts (name, type, complete, profile_id) values ('sit', 'tristique', true,6);
insert into workouts (name, type, complete, profile_id) values ('nec', 'accumsan', true,8);
insert into workouts (name, type, complete, profile_id) values ('dapibus', 'dui', false,9);

insert into sets (exercise_repetitions, profile_id, workout_id ) values (45, 1, 1);
insert into sets (exercise_repetitions, profile_id, workout_id ) values (83, 2, 2);
insert into sets (exercise_repetitions, profile_id, workout_id ) values (41, 3, 3);
insert into sets (exercise_repetitions, profile_id, workout_id ) values (11, 4, 4);
insert into sets (exercise_repetitions, profile_id, workout_id ) values (95, 5, 5);
insert into sets (exercise_repetitions, profile_id, workout_id ) values (94, 6, 6);
insert into sets (exercise_repetitions, profile_id, workout_id ) values (60, 7, 7);
insert into sets (exercise_repetitions, profile_id, workout_id ) values (37, 8, 8);
insert into sets (exercise_repetitions, profile_id, workout_id ) values (47, 9, 9);
insert into sets (exercise_repetitions, profile_id, workout_id ) values (34, 10, 10);

insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (1,'Crunches', 'Lying on your back, feet on the gound and hands behind your head, crunch up and bring hands to touch knees before rolling back to the ground', 'Core', 'https://image.shutterstock.com/image-vector/woman-doing-crunches-gym-belly-600w-1234348741.jpg', 'https://www.youtube.com/embed/Xyd_fa5zoEU');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (2,'Side plank', 'Start with elbow, hip and forearm on the floor. Raise hip until armpit level.', 'Core', 'https://image.shutterstock.com/image-photo/side-plank-exercise-athletic-woman-600w-1751568857.jpg', 'https://www.youtube.com/embed/rCxF2nG9vQ0');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (3,'Plank', 'With both forearms and toes on the floor, keep head, shoulders, hips and knees aligned', 'Core', 'https://image.shutterstock.com/image-photo/strong-beautiful-fitness-girl-athletic-600w-1497529061.jpg', 'https://www.youtube.com/embed/yeKv5oX_6GY');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (4,'Russian twists', 'Sit on the floor with you knees bend. Keep knees togetehr and feet together. Interlacer your fingers, strech your arms and twist as far as possible to each side', 'Core', 'https://as1.ftcdn.net/v2/jpg/00/82/28/00/1000_F_82280003_lpOmNiqJbXbzadkBzxQxzVLCH2in44vf.jpg', 'https://www.youtube.com/embed/nhFynCkYtD4');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (5'Jumping jacks', 'Stand feet together, arms by your side. Jump your feet to the sides, wider than hip distance while bring your straight arms to meet above your head.', 'Full body', 'https://image.shutterstock.com/image-vector/jumping-jacks-exercise-girl-workout-600w-1633713496.jpg', 'https://www.youtube.com/embed/iSSAk4XCsRA');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (6,'Push up', 'Feet and hands on the floor, arms straight, body rigid Bend arms till you nose almost touces the floo, and lift yourself back up to starting position. ', 'Full body', 'https://media.istockphoto.com/vectors/push-ups-exercises-and-yoga-vector-illustration-vector-id1161576679?s=612x612', 'https://www.youtube.com/embed/_l3ySVKYVJ8');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (7,'Burpee', 'Start by standing feet hip distance apart arms by your side. Put your hands to the floor and jump your feet back to push up position. Jump your feet back between your hands and jum up with arms above your head.', 'Full body', 'https://media.istockphoto.com/vectors/exercise-guide-with-woman-doing-the-squat-thrust-burpee-position-in-3-vector-id1147316374?s=612x612', 'https://www.youtube.com/embed/TU8QYVW0gDU');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (8,'Reverse crunches', 'Start lying on your back, legs straigt, arms by your side. Keep feet together while you raise your legs above your hips.', 'Full body', 'https://image.shutterstock.com/image-vector/girl-doing-reverse-crunch-exercise-600w-1709322895.jpg', 'https://www.youtube.com/embed/gAyTBB4lm3I');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (9,'Squat', 'Start standing with feet almost shoulderwith apart. Without letting your knees go over your toes, bend knees and lower down till hips are below knees.', 'Lower body', 'https://thumbs.dreamstime.com/z/squat-sport-exersice-silhouettes-woman-doing-exercise-workout-training-squat-sport-exersice-silhouettes-woman-doing-exercise-119786597.jpg', 'https://www.youtube.com/embed/aclHkVaku9U');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (10'Jump squat', 'Start standing with feet almost shoulderwith apart. Without letting your knees go over your toes, bend knees and lower down till hips are below knees. Come up into a jump.', 'Lower body', 'https://image.shutterstock.com/image-vector/man-doing-jump-squat-exercise-600w-1991346719.jpg', 'https://www.youtube.com/embed/Azl5tkCzDcc');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (2'Lunges', 'Start standing upright hands on hips. Step forward with one foot.Back knee touches ground below hip', 'Lower body', 'https://thumbs.dreamstime.com/z/man-doing-dumbbell-walking-lunges-exercise-man-doing-dumbbell-walking-lunges-exercise-flat-vector-illustration-isolated-white-230812187.jpg', 'https://www.youtube.com/embed/Pt5ThtTfn_U');
insert into exercises (set_id, name, description, target_muscle_group, image, video_link) values (1'Hip raises', 'Start lying on your back, knees bend, feet on the floor. Lift hips off the floor until fully extended shouldblades lifted off the floor. Slowly lower back down', 'Lower body', 'https://image.shutterstock.com/z/stock-photo-hip-raises-360740402.jpg', 'https://www.youtube.com/embed/fDP6O_aJpDg');

insert into goals (end_date, achieved) values ('2021-06-30', false);
insert into goals (end_date, achieved) values ('2021-10-16', true);
insert into goals (end_date, achieved) values ('2021-09-06', true);
insert into goals (end_date, achieved) values ('2021-12-08', true);
insert into goals (end_date, achieved) values ('2021-04-10', true);
insert into goals (end_date, achieved) values ('2021-12-21', false);
insert into goals (end_date, achieved) values ('2021-07-20', true);
insert into goals (end_date, achieved) values ('2021-05-04', true);
insert into goals (end_date, achieved) values ('2021-05-29', false);
insert into goals (end_date, achieved) values ('2021-03-14', false);

insert into programs (name, category, profile_id) values ('vel', 'at', 1);
insert into programs (name, category, profile_id) values ('interdum', 'magna', 2);
insert into programs (name, category, profile_id) values ('duis', 'ultrices', 3);
insert into programs (name, category, profile_id) values ('montes', 'leo', 10);
insert into programs (name, category, profile_id) values ('sit', 'at', 4);
insert into programs (name, category, profile_id) values ('aliquam', 'tincidunt', 5);
insert into programs (name, category, profile_id) values ('nulla', 'congue', 6);
insert into programs (name, category, profile_id) values ('tristique', 'gravida', 7);
insert into programs (name, category, profile_id) values ('magnis', 'id', 8);
insert into programs (name, category, profile_id) values ('gravida', 'vel', 9);
