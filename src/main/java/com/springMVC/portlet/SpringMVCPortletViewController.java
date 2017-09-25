package com.springMVC.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * @author
 */
@Controller
@RequestMapping("VIEW")
public class SpringMVCPortletViewController {

	@RenderMapping
	public ModelAndView view(RenderRequest request, RenderResponse response) {
		ModelAndView modelAndView = new ModelAndView("view");
		return modelAndView;
	}

	@RenderMapping(params = "action=add")
	public ModelAndView addEmployee(RenderRequest req, RenderResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("add");
		return modelAndView;
	}

	@ActionMapping
	public void createEmp(ActionRequest req, ActionResponse res) {
		String name = req.getParameter("name");
		System.out.println("name-----------"+name);
		//业务逻辑处理
	}
	
}