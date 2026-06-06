package com.ayushi.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayushi.Entity.Issue;
import com.ayushi.Entity.IssueComment;
import com.ayushi.Entity.Sprint;
import com.ayushi.Enum.IssueStatus;
import com.ayushi.Services.IssueService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/issues")
@RequiredArgsConstructor
public class IssueController {
	
	
	@Autowired
	private IssueService issueService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createIssue(@RequestBody Issue issue){
		issueService.createIssue(issue);
		return ResponseEntity.ok("Task got created");
	}


	@GetMapping("/{assigneeEmail}")
	public ResponseEntity<List<Issue>> getIssueByAssigneedEmail(@PathVariable String userEmail){
		return ResponseEntity.ok(issueService.findIssueByAssigneeEmail(userEmail));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Issue>getIssueById(@PathVariable Long id){
		return ResponseEntity.ok(issueService.findIssueById(id));
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<Issue>updateIssueStatus(@RequestParam IssueStatus issueStatus,@PathVariable Long id){
		return ResponseEntity.ok(issueService.updateIssueStatus(id, issueStatus));
	}

	@PostMapping("/addComments/{issueId}")
	public ResponseEntity<IssueComment>addComeents(@PathVariable Long isueId,
			                                       @RequestParam String authorEmail,
			                                        @RequestBody String body){
		return ResponseEntity.ok(issueService.addComment(isueId, authorEmail, body));
	}

	@PostMapping("/sprint")
	public ResponseEntity<Sprint>createSprint(@RequestBody Sprint sprint){
		return ResponseEntity.ok(issueService.createSprint(sprint));
	}

	@GetMapping("/spint/{sprintId}")
	public ResponseEntity<List<Issue>>getIssueBySprint(@PathVariable Long sprintId){
		return ResponseEntity.ok(issueService.findIssueBySprint(sprintId));
	}

	@PostMapping("/search")
	public ResponseEntity<List<Issue>>search(@RequestBody Map<String,String>filters){
		return ResponseEntity.ok(issueService.search(filters));
	}
}

