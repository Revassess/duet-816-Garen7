SELECT app_user.username, study_set.name, category.name, flashcard.question, flashcard.answer FROM study_set
    RIGHT JOIN app_user ON study_set.owner_id = app_user.user_id
    RIGHT JOIN study_set_card ON study_set.study_set_id = study_set_card.study_set_id
    RIGHT JOIN flashcard ON study_set_card.flashcard_id = flashcard.flashcard_id
    RIGHT JOIN category ON flashcard.category_id = category.category_id
    WHERE study_set.owner_id = 4;