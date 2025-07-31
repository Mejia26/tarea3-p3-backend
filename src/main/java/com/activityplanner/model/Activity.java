package com.activityplanner.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "activities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {

	 @Id
	    @GeneratedValue(strategy = GenerationType.UUID)
	    private UUID id;

	    private String name;
	    private String icon;
	    private String color;
	    private String description;
	    private String secondColor;
	    private LocalDateTime createdAt;
	    private String homeLinkBtn;
	    private LocalDateTime selectedHour;
	    
	    @PrePersist
	    public void onCreate() {
	    	createdAt = LocalDateTime.now();
	    	selectedHour = LocalDateTime.now();
	    }
}
