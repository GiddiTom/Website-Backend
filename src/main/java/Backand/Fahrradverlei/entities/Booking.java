package Backand.Fahrradverlei.entities;



	import java.sql.Date;
	import java.util.UUID;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;
	import javax.validation.constraints.NotNull;

	import org.hibernate.annotations.NotFound;
	import org.hibernate.annotations.NotFoundAction;

	@Entity
	@Table(name="booking")
	public class Booking {
		
		@Id
		@Column(columnDefinition= "VARBINARY(16)")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private UUID id;
		
		@Column
		@NotNull
		private Date bookingDate;
		
		@Column
		@NotNull
		private Date apprxReturnDate;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@NotFound(action=NotFoundAction.IGNORE)
		@JoinColumn(name = "fahrrad_id", referencedColumnName = "id")
		private Fahrrad vo;
		
		@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
		@NotFound(action=NotFoundAction.IGNORE)
		@JoinColumn(name = "user_id", referencedColumnName = "id")
		private User user;
		
		public Booking() {
			
		}

		public Booking(@NotNull Date bookingDate, @NotNull Date apprxReturnDate, Fahrrad vo, User user) {
			super();
			
			this.bookingDate = bookingDate;
			this.apprxReturnDate = apprxReturnDate;
			this.vo = vo;
			this.user = user;
		}

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public Date getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}

		public Date getApprxReturnDate() {
			return apprxReturnDate;
		}

		public void setApprxReturnDate(Date apprxReturnDate) {
			this.apprxReturnDate = apprxReturnDate;
		}

		public Fahrrad getVo() {
			return vo;
		}

		public void setVo(Fahrrad vo) {
			this.vo = vo;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

	
		

	}

