function getProjectList(){
	$.ajax({
		url : "/project/userProjects/" + userId,
		type : "get", // send it through get method
		success : function(response) {
			setProjects(response);
		},
		error : function(xhr) {
			alert(xhr.statusCode);
		}
	});
}

function setProjects(projectsList){
	
	// show the list of all projects
	
//	getProjectEmps(projectsList[0].id);
	getManagerProjectEmps(projectsList[0].id)
	
//	if(projectsList!=null && projectsList.length == 1) {
//		//hide the project dropdown
//		getProjectEmps(projectsList[0].id);
//	}
//	else {
//		//show the project drop down
//		
//		//add projects to drop dropdown
//	}
}

function getProjectEmps(projectsId){
	$.ajax({
		url : "/project/users/" + projectsId,
		type : "get", // send it through get method
		success : function(response) {
//			setProjects(response);
			setEmployees(response);
		},
		error : function(xhr) {
			alert(xhr.statusCode);
		}
	});
}

function getManagerProjectEmps(projectsId){
	$.ajax({
		url : "/project/manager/" + projectsId,
		type : "get", // send it through get method
		success : function(response) {
//			setProjects(response);
			setEmployees(response);
		},
		error : function(xhr) {
			alert(xhr.statusCode);
		}
	});
}

function setEmployees(employeeList) {
	
	//loop the employee list and call the getEmpfeedback details for each emp 
	
//	$.ajax({
//		url : "/feedback/user/" + employeeList[1].id,
//		type : "get", // send it through get method
//		success : function(response) {
////			setProjects(response);
////			setEmployee(response);
//		},
//		error : function(xhr) {
//			alert(xhr.statusCode);
//		}
//	});
}

var questionListGbl;
function openNewFeedbackForm() {
	var selectId = $('#employeeList').val();
	if (selectId > 0) {
		$.ajax({
			url : "/feedback/questions/" + selectId,
			type : "get", // send it through get method
			success : function(response) {
				setFeedbackForm(response);
			},
			error : function(xhr) {
				alert(xhr.statusCode);
			}
		});
	}
}

function setFeedbackForm(questionsList) {
	$('#question_tbl tbody').html();
	if (questionsList != null) {
		questionListGbl = questionsList;
		var htmlData = [];
		$.each(questionsList, function(key, value) {
			var i = key + 1;
			htmlData.push('<tr>');
			htmlData.push('<td>' + i + '</td>');
			htmlData.push('<td style="width: 55%;">' + value.value + '</td>');
			htmlData.push('<td style="width: 95%;"><textarea id="' + value.id
					+ '" cols="120" rows="5"></textarea></td>');
			htmlData.push('</tr>');
		});
		$('#question_tbl tbody').html(htmlData.join(''));
		$('#question_tbl').closest("div").show();
	}

}

function submitFeedback() {
	var map = new Object();
	$.each(questionListGbl, function(key, value) {
		var rating = $('#rating' + value.id).val()
		var answer =  $('#' + value.id).val()+'|'+rating;
		map[value.id] = answer;
	});
	$.ajax({
		url : "/feedback/submit",
		type : "post",
		contentType : "application/json",
		data : JSON.stringify({
			"answerMap" : map
		}),
		success : function(response) {
			resetFeedback();
			$('#message').html(response);
			$('#message').show(0).delay(5000).hide(0);;
		},
		error : function(xhr) {
			alert(xhr.statusCode);
		}
	});
}

function resetFeedback() {
	$('#question_tbl tbody').html();
	$('#question_tbl').closest("div").hide();
	$('#employeeList').val('-1');
}

function openFeedbackForm() {
	var selectId = $('#employeeManList').val();
	if (selectId > 0) {
		$.ajax({
			url : "/feedback/submittedFeedback/" + selectId,
			type : "get", // send it through get method
			success : function(response) {
				setSubmittedFeedback(response);
			},
			error : function(xhr) {
				alert(xhr.statusCode);
			}
		});
	}
}

function setSubmittedFeedback(feedbackList) {
	$('#feedback_div').html();
	if (feedbackList != null) {
//		questionListGbl = questionsList;
		var htmlData = [];
		$.each(feedbackList, function(key, value) {
			htmlData.push('<table id="feedback_tbl" class="tableCSS"><thead><tr><th>S.No</th><th>Question</th><th>Feedback</th></tr></thead><tbody>');
			$.each(value, function(k, value) {
				var i = k + 1;
				htmlData.push('<tr>');
				htmlData.push('<td>' + i + '</td>');
				htmlData.push('<td style="width: 55%;">' + value.question + '</td>');
				htmlData.push('<td style="width: 55%;">' + value.answer + '</td>');
				htmlData.push('</tr>');
				
			});
			htmlData.push('</tbody></table>');
			htmlData.push('<br>');
		});
//		alert("htmlData:"+htmlData);
		$('#feedback_div').html(htmlData.join(''));
		$('#feedback_div').show();
	}
}
