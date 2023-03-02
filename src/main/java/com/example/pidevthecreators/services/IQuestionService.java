package com.example.pidevthecreators.services;

import com.example.pidevthecreators.entities.Question;

import java.util.List;

public interface IQuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question,Long id);
    public Question retrieveQuestion(Long id);
    public List<Question> retrieveAllQuestion();
    public void deleteQuestion(Long id);
    public void  deleteAllQuestion();
    public void addandsignquestion(Question question,Long idQuiz);

    void addandsignquestion(Question question, int id);

    public List<Question> getQuestions() ;

   // void addandsignquestion(Question question, int id);*/
}
