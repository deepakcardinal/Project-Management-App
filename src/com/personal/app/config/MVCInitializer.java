package com.personal.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author Deepak.Dogra
 *
 */

public class MVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

@Override
 protected Class<?>[] getRootConfigClasses() {
 return new Class[] { ViewConfig.class };
 }

 @Override
 protected Class<?>[] getServletConfigClasses() {
 return null;
 }

 @Override
 protected String[] getServletMappings() {
 return new String[] { "/" };
 }

}
