package techmaster.demo.Lab04.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techmaster.demo.Lab04.model.Job;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    private List<Job> jobList = new ArrayList<>();

    @GetMapping("/random")
    public ResponseEntity<Job> getRandomJob() {
        if (jobList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(jobList.size());
        Job randomJob = jobList.get(randomIndex);

        return new ResponseEntity<>(randomJob, HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Job>> getSortedJobs(@RequestParam(name = "max_salary", required = false) String sortOrder) {
        if (jobList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Job> sortedJobs;
        if ("desc".equalsIgnoreCase(sortOrder)) {
            sortedJobs = jobList.stream()
                    .sorted(Comparator.comparingInt(Job::getMaxSalary).reversed())
                    .collect(Collectors.toList());
        } else {
            sortedJobs = jobList;
        }

        return new ResponseEntity<>(sortedJobs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createJob(@RequestBody Job newJob) {
        newJob.setId(generateUniqueId());
        jobList.add(newJob);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(jobList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable String id) {
        Job job = findJobById(id);
        if (job == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateJob(@PathVariable String id, @RequestBody Job updatedJob) {
        Job job = findJobById(id);
        if (job == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        job.setTitle(updatedJob.getTitle());
        job.setDescription(updatedJob.getDescription());
        job.setLocation(updatedJob.getLocation());
        job.setMinSalary(updatedJob.getMinSalary());
        job.setMaxSalary(updatedJob.getMaxSalary());
        job.setEmailTo(updatedJob.getEmailTo());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable String id) {
        Job job = findJobById(id);
        if (job == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        jobList.remove(job);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private String generateUniqueId() {
        return java.util.UUID.randomUUID().toString();
    }

    private Job findJobById(String id) {
        return jobList.stream()
                .filter(job -> job.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
