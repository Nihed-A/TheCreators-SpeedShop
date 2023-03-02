package com.example.pidevthecreators.services;

import com.example.pidevthecreators.entities.Question;
import com.example.pidevthecreators.repositories.EvaluationCustomerRepository;
import com.example.pidevthecreators.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class QuestionServiceImp implements IQuestionService{

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    EvaluationCustomerRepository evaluationCustomerRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question, Long id) {
        question.setId(id);
        return questionRepository.save(question);
    }

    @Override
    public Question retrieveQuestion(Long id) {
        return null;
    }

    @Override
    public List<Question> retrieveAllQuestion() {
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {

    }

    @Override
    public void deleteAllQuestion() {

    }

    @Override
    public void addandsignquestion(Question question, Long idQuiz) {

    }
    @Override
    public void addandsignquestion(Question question, int id) {

    }

    @Override
    public List<Question> getQuestions() {
        return null;
    }

}
