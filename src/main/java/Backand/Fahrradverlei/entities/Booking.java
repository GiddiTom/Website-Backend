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
	
		@ManyToOne(fetch=FetchType.LAZY)
		@NotFound(action=NotFoundAction.IGNORE)
		@JoinColumn(name = "startid", referencedColumnName = "id")
		private Standort Start;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@NotFound(action=NotFoundAction.IGNORE)
		@JoinColumn(name = "endeid", referencedColumnName = "id")
		private Standort Ende;
		
		
		@Column
		@NotNull
		private boolean aktiv;
		
		
		public Booking() {
			
		}

		public Booking(@NotNull Date bookingDate, @NotNull Date apprxReturnDate, Fahrrad vo, User user, boolean aktivierend, Standort Start, Standort Ende) {
			super();
			
			this.bookingDate = bookingDate;
			this.apprxReturnDate = apprxReturnDate;
			this.vo = vo;
			this.user = user;
			this.Start = Start;
			this.Ende = Ende;
			this.aktiv = aktivierend;
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

		public boolean isAktiv() {
			return aktiv;
		}

		public void setAktiv(boolean aktiv) {
			this.aktiv = aktiv;
		}

		public Standort getStart() {
			return Start;
		}

		public void setStart(Standort start) {
			Start = start;
		}

		public Standort getEnde() {
			return Ende;
		}

		public void setEnde(Standort ende) {
			Ende = ende;
		}
	
		

	}

