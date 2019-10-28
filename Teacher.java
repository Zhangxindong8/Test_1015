//教师类
public class Teacher {
	private String name;
	private String sex;
	private String num;
	private int age;
	private int teaAge;
	private String zhiCheng;
	private String[] courseNames;
	//教师类的特性
	public void shangKe()
	{
		System.out.println(name+"在上课");
	}
	public void beiKe()
	{
		System.out.println(name+"在备课");
	}
	//教师类的行为
	public Teacher(String name,String num,String sex,int age,int teaAge)
	{
		this.name=name;
		this.setNum(num);
		this.setSex(sex);
		this.setAge(age);
		this.setTeaAge(teaAge);
	}
	//教师类的构造方法
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	//私有属性的设置和获取方法
	public void setSex(String sex) {
		if((sex.equals("男"))||(sex.equals("女")))
		{
			this.sex = sex;
		}
	}
	public String getSex() {
		return sex;
	}
	public void setNum(String num) {
		String str=checkNum(num);
		if(str.equals(""))
		{
			this.num = num;
		}
		else
		{
			System.out.println(str);
		}
	}
	
	private String checkNum(String num)
	{
		String result="";
		if(num.length()!=5)
		{
			result="教师编号长度不是5位";
		}
		else
		{
			char ch=num.charAt(0);//将教师编号参数的第一个字符赋给变量ch
			if(ch!='T')
			{
				result="教师编号第一位不是大写T";
			}
			else
			{
				for(int i=1;i<num.length();i++)
				{
					char ch1=num.charAt(i);
					if((ch1<'0')||(ch>'9'))
					{
						result="教师编号后4位有非数字字符";
						break;
					}
				}
			}
		}
		return result;
	}
	public String getNum() {
		return num;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setTeaAge(int teaAge) {
		this.teaAge = teaAge;
	}
	public int getTeaAge() {
		return teaAge;
	}
	public void setZhiCheng(String zhiCheng) {
		this.zhiCheng = zhiCheng;
	}
	public String getZhiCheng() {
		return zhiCheng;
	}
	public void setCourseNames(String[] courseNames) {
		this.courseNames = courseNames;
	}
	public String[] getCourseNames() {
		return courseNames;
	}
}
