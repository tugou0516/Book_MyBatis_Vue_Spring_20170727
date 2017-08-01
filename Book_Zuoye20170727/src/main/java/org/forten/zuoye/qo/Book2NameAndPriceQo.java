package org.forten.zuoye.qo;

public class Book2NameAndPriceQo {
	private String name;
	private double priceMin;
	private double priceMax;
	public Book2NameAndPriceQo() {
		super();
	}
	public Book2NameAndPriceQo(String name, double priceMin, double priceMax) {
		super();
		this.name = name;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
	}
	public String getSql(Book2NameAndPriceQo qo){
		String sql = "SELECT id,name,author,publisher,pub_date,price,discount,creat_time FROM test_book2 WHERE 1=1 ";
		if(qo.getName()!=null && !qo.getName().equals("")){
			qo.setName("%"+qo.getName()+"%");
			sql = sql + "AND name LIKE #{name} ";
		}
		/*if(qo.getPriceMin()>qo.getPriceMax()){
			sql = sql + "AND price BETWEEN #{priceMax} AND #{priceMin} ";
		}else {
			sql = sql + "AND price BETWEEN #{priceMin} AND #{priceMax} ";
		}*/
		if(qo.getPriceMin()!=0 && qo.getPriceMax()!=0){
			if(qo.getPriceMin()>qo.getPriceMax()){
				sql = sql + "AND price BETWEEN #{priceMax} AND #{priceMin} ORDER BY price ";
			}
			if(qo.getPriceMin()<=qo.getPriceMax()){
				sql = sql + "AND price BETWEEN #{priceMin} AND #{priceMax} ORDER BY price ";
			}
		}
		if(qo.getPriceMin()==0 && qo.getPriceMax()!=0){
			sql = sql + "AND price BETWEEN 0 AND #{priceMax} ORDER BY price ";
		}
		if(qo.getPriceMin()!=0 && qo.getPriceMax()==0){
			sql = sql + "AND price>= #{priceMin} ORDER BY price ";
		}
		return sql;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(double priceMin) {
		this.priceMin = priceMin;
	}
	public double getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priceMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceMin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book2NameAndPriceQo other = (Book2NameAndPriceQo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(priceMax) != Double.doubleToLongBits(other.priceMax))
			return false;
		if (Double.doubleToLongBits(priceMin) != Double.doubleToLongBits(other.priceMin))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book2NameAndPriceQo [name=" + name + ", priceMin=" + priceMin + ", priceMax=" + priceMax + "]";
	}
	
}
