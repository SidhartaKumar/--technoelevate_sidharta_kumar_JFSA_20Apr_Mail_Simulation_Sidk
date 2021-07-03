package com.te.mailsimulation.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "mail_info")
@XmlRootElement(name="mail")
@JsonRootName("mail")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MailBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	@XmlElement
	private int mid;
	@Column
	@JsonProperty
	@XmlElement
	private String subject;
	@Column
	@JsonProperty
	@XmlElement
	private String message;
	@Column
	@JsonProperty
	@XmlElement
	private String status;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "from_id", nullable = false)
	private UserBean user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "to_id", nullable = false)


	private UserBean userBean;
	
}
