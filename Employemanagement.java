import java.sql.*;
import java.io.*;
class Employemanagement
{
	public static void main(String args[])
	{
		Connection con=null;
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Class.forName("com.mysql.cj.jdbc.Driver");  //this class register the driver
			System.out.println("Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loki","root",""); 
			System.out.println("Connected");
			Statement st=con.createStatement();
			while(true)
			{
				System.out.println("\n1.AddEmploy\n2.UpdateEmploy\n3.DeleteEmploy\n4.DisplayEmploy\n5.Exit");
				System.out.println("Enter Your Choice  ");
				int ch=Integer.parseInt(br.readLine());
				switch(ch)
{
					case 1:
					System.out.println("Enter the Employ Number ");
					int eno=Integer.parseInt(br.readLine());
					System.out.println("Enter the Employ Name ");
					String name=br.readLine();
					System.out.println("Enter the Employ Salary ");
					int sal=Integer.parseInt(br.readLine());
					String sql="insert into employ values("+eno+",'"+name+"',"+sal+")";
					st.executeUpdate(sql);
					System.out.println("Employee Added Successfully...");
					break;
					case 2:
					System.out.println("Enter the Employ Number ");
					eno=Integer.parseInt(br.readLine());
                                        System.out.println("Enter the Employ New Salary ");
					sal=Integer.parseInt(br.readLine());
					sql="update employ set sal="+sal+" where empno="+eno;
					st.executeUpdate(sql);
					System.out.println("Employee Updated Successfully...");
					break;
					case 3:
					System.out.println("Enter the Employ Number ");
					eno=Integer.parseInt(br.readLine());
					sql="delete from employ where empno="+eno;
					st.executeUpdate(sql);
                                        System.out.println("Employee Deleted Successfully...");
					break;
					case 4:
					ResultSet rs=st.executeQuery("select * from employ");
					ResultSetMetaData rsmd=rs.getMetaData();
					int cc=rsmd.getColumnCount();
					for(int i=1;i<=cc;i++)
					{
							System.out.print(rsmd.getColumnLabel(i)+"\t");
					}
					System.out.println();
					while(rs.next())
					{
                                        for(int i=1;i<=cc;i++)
						{
							System.out.print(rs.getString(i)+"\t");
						}
						System.out.println();
					}
					break;
				case 5:System.exit(0);
				default:System.out.println("Invalid Choice");
					

				}
				
			}
		}catch(Exception ce)
		{
			System.out.println(ce);
		}
		
	}
}