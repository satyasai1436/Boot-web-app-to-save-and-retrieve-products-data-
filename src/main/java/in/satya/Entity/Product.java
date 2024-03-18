	package in.satya.Entity;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	
	
	@Entity
	public class Product {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer pId;
		private String pName;
		private Double pPrice;
		private String pDate;
		public Integer getpId() {
			return pId;
		}
		public void setpId(Integer pId) {
			this.pId = pId;
		}
		public String getpName() {
			return pName;
		}
		public void setpName(String pName) {
			this.pName = pName;
		}
		public Double getpPrice() {
			return pPrice;
		}
		public void setpPrice(Double pPrice) {
			this.pPrice = pPrice;
		}
		public String getpDate() {
			return pDate;
		}
		public void setpDate(String pDate) {
			this.pDate = pDate;
		}
		@Override
		public String toString() {
			return "Product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + ", pDate=" + pDate + "]";
		}
		
		
		
	
	}
