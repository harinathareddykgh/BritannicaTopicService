package com.britannica.topicservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name = "TOPIC")
@JacksonXmlRootElement(localName  ="url-publish")
public class TopicBean {

	@Id
    @GeneratedValue
    @Column(name = "TOPIC_ID", nullable = false)
	private Integer topicId;
	
	@Column(name = "URL_TITLE")
	private String urlTitle;
	
	@Column(name = "URL_CLASS")
	private String urlClass;
	
	@XmlElement
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	@XmlElement
	public String getUrlTitle() {
		return urlTitle;
	}
	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}
	@XmlElement
	public String getUrlClass() {
		return urlClass;
	}
	public void setUrlClass(String urlClass) {
		this.urlClass = urlClass;
	}
	@Override
	public String toString() {
		return "TopicBean [topicId=" + topicId + ", urlTitle=" + urlTitle + ", urlClass=" + urlClass + "]";
	}
	
	
}
