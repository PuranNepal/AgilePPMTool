package io.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.exceptions.ProjectIdException;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try{
            project.setProjectIdentifer(project.getProjectIdentifer().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e){
            throw new ProjectIdException("Project ID " + project.getProjectIdentifer().toUpperCase() + " already exist");
        }
    }

    public Project findProjectByIdentifer(String projectId){
        Project project = projectRepository.findByProjectIdentifer(projectId.toUpperCase());
        if(project == null){
            throw new ProjectIdException("Project ID " + projectId.toUpperCase() + " does not exist");
        }

        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifer(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Project ID " + projectId.toUpperCase() + " does not exist");
        }

        projectRepository.delete(project); 
    }
}
