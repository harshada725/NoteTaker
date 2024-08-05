package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Note {
	
	@Id
	@GeneratedValue
	@Column(name="Note_Id")
	
	private Integer noteId;
	
    @Column(name="note_title",length = 255)
	private String noteTitle;
    
    @Column(name="note_content",columnDefinition="TEXT")
	private String noteContent;
    
    @Column(name="addedDate")
	private Date addedDate;
    
	public Note() {
		// TODO Auto-generated constructor stub
	}

	public Note(Integer noteId, String noteTitle, String noteContent, Date addedDate) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.addedDate = addedDate;
	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
}
