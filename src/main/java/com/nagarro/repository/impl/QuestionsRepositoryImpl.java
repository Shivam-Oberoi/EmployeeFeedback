package com.nagarro.repository.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.nagarro.model.Answers;
import com.nagarro.model.Feedback;
import com.nagarro.model.Questions;
import com.nagarro.repository.QuestionsRepository;

@Repository
public class QuestionsRepositoryImpl implements QuestionsRepository{
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public List<Questions> findAll() {
		StoredProcedureQuery getUserStoredProcedure = em.createNamedStoredProcedureQuery("findAllQuestionsSP");
		getUserStoredProcedure.execute();
		List<Questions> questions = getUserStoredProcedure.getResultList();
		System.out.println("the list:"+questions.size());
		return questions;
	}

	@Override
	public String submitFeedback(Integer empId, long id, Answers answers) {
		
		StringBuilder input = new StringBuilder();
		String result = "";
//		JsonObject root = new JsonObject();
//		root.addProperty("id", "prod");
//
//		JsonElement element = new JsonParser().parse(complexJsonString);
//		root.addProperty("data", element);
//		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//		String jsonString = gson.toJson(answers.getAnswerMap());
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.writeValue(new D, answers.getAnswerMap());
		input.append("[");
		answers.getAnswerMap().forEach((k,v) -> {
//			input.append(k+":"+v+"|");
			String[] datavalue = v.split("|");
			input.append("{");
			input.append("\"id\":\"");
			input.append(k+"\"");
			input.append(",");
			input.append("\"data\":\"");
			input.append(datavalue[0]+"\"");
			input.append(",");
			input.append("\"rating\":\"");
			input.append(datavalue[1]+"\"");
//			StoredProcedureQuery getUserStoredProcedure = em.createNamedStoredProcedureQuery("saveFeedbackSP");
//			getUserStoredProcedure.setParameter("UserId", id);
//			getUserStoredProcedure.setParameter("EmpId",empId);
//			getUserStoredProcedure.setParameter("Ans", v);
//			getUserStoredProcedure.setParameter("QuesId", Integer.valueOf(k));
//			getUserStoredProcedure.setParameter("FeedbackNo", feedbackNo);
//			getUserStoredProcedure.execute();
//			resultBuilder.append((String) getUserStoredProcedure.getOutputParameterValue("Result"));
//			resultBuilder.append(":");
			input.append("},");
		});
		input.replace(0, input.length(), (String) input.subSequence(0, input.length()-1));
		input.append("]");
		System.out.println("JSON string:"+input);
		
		StoredProcedureQuery getUserStoredProcedure = em.createNamedStoredProcedureQuery("saveFeedbackSP");
		getUserStoredProcedure.setParameter("UserId", id);
		getUserStoredProcedure.setParameter("EmpId",empId);
		getUserStoredProcedure.setParameter("Ans", input.toString());
		getUserStoredProcedure.execute();
		result = (String) getUserStoredProcedure.getOutputParameterValue("Result");
		
//		BigInteger feedbackNo = (BigInteger) em.createNativeQuery("SELECT NEXT VALUE FOR dbo.QuestionAnswerSeq").getSingleResult();
//		StringBuilder resultBuilder = new StringBuilder();
//		String result = "";
//		answers.getAnswerMap().forEach((k,v) -> {
//			StoredProcedureQuery getUserStoredProcedure = em.createNamedStoredProcedureQuery("saveFeedbackSP");
//			getUserStoredProcedure.setParameter("UserId", id);
//			getUserStoredProcedure.setParameter("EmpId",empId);
//			getUserStoredProcedure.setParameter("Ans", v);
//			getUserStoredProcedure.setParameter("QuesId", Integer.valueOf(k));
//			getUserStoredProcedure.setParameter("FeedbackNo", feedbackNo);
//			getUserStoredProcedure.execute();
//			resultBuilder.append((String) getUserStoredProcedure.getOutputParameterValue("Result"));
//			resultBuilder.append(":");
//		});
//		
//		if(resultBuilder!= null && resultBuilder.toString().contains("Error")) {
//			result = "Error while submitting feedback.";
//		}
//		else {
//			result = resultBuilder.toString().substring(0, resultBuilder.toString().indexOf(":"));
//		}
		return result;
	}

//	@Override
//	public Map<Long, List<Feedback>> findFeedbackById(Integer id) {
//		StoredProcedureQuery getUserStoredProcedure = em.createNamedStoredProcedureQuery("findFeedbackSP");
//		getUserStoredProcedure.setParameter("Id", id);
//		getUserStoredProcedure.execute();
//		List<Feedback> feedbacks = getUserStoredProcedure.getResultList();
//		Consumer<Feedback> c1 = System.out::println;
//		System.out.println("the list:"+feedbacks.size());
//		feedbacks.forEach(c1);
////		Map<Long, Set<Long>> result =
////				feedbacks.stream().collect(
////                        Collectors.groupingBy(
////                                Feedback::getFeedbackNo,
////                                Collectors.mapping(Feedback::getId, Collectors.toSet())
////                        )
////                );
//		
//		Map<Long, List<Feedback>> result =
//				feedbacks.stream().collect(
//                        Collectors.groupingBy(
//                                Feedback::getFeedbackNo
//                        )
//                );
//		
//		System.out.println(result);
//		return result;
//	}
	
	@Override
	public List<Feedback> findFeedbackById(Integer id) {
		StoredProcedureQuery getUserStoredProcedure = em.createNamedStoredProcedureQuery("findFeedbackSP");
		getUserStoredProcedure.setParameter("Id", id);
		getUserStoredProcedure.execute();
		List<Feedback> feedbacks = getUserStoredProcedure.getResultList();
		
		System.out.println(feedbacks);
		return feedbacks;
	}
	

//	@Override
//	public List<Answers> findFeedbackById(Integer id) {
//		System.out.println("ïnteger"+id);
//		Query query =em.createNativeQuery("SELECT a.[text]\r\n" + 
//				"      ,q.[value]\r\n" + 
//				"      ,qa.[feedbackno]\r\n" + 
//				"      ,qa.[startdate]\r\n" + 
//				"  FROM [dbo].[question_answer] qa\r\n" + 
//				"  JOIN [dbo].[answers] a\r\n" + 
//				"  ON qa.[answerid] = a.[id]\r\n" + 
//				"  JOIN [dbo].[questions] q\r\n" + 
//				"  ON qa.[questionid] = q.[id]\r\n" + 
//				"  WHERE qa.toid= ?1");
//		query.setParameter(1, id);
//		List<Answers> answers = new ArrayList<Answers>();
//		Consumer<Object[]> c1 = (o) -> {
////			Answers ans = new Answers();
////			ans.setAnswerMap(new HashMap<String,String>());
//			for(Object obj : o) {
////			ans.getAnswerMap().put(obj, value)
//				
//			}
//			o[0];
//			o[1];
//			o[2];
//			o[3];
//		};
//		query.getResultList().forEach(c1);
//		return null;
//	}


}

