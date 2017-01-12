package cpes.act;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAct1 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/*.xml");
		
		ProcessEngine bean = context.getBean("processEngine",ProcessEngine.class);
		RepositoryService repositoryService = bean.getRepositoryService();
		Deployment deploy = repositoryService.createDeployment().addClasspathResource("MyProcess.bpmn").deploy();
		
		
		
		
		System.out.println(bean);
	}
}
