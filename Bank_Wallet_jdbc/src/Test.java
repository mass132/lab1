import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.capg.wallet.beans.Transaction;
import com.capg.wallet.dao.WalletDB;

public class Test {

	@SuppressWarnings("deprecation")
	public static void test() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String queryTransaction = "INSERT INTO bank_wallet_transaction values(?,?,?,?,?,?,?)";
		String queryAccount = "INSERT INTO bank_wallet_account values(?,?,?,?,?,?)";
		try {
			conn = WalletDB.getConnection();
			stmt = conn.prepareStatement(queryAccount);
			stmt.setString(1, "SDA1234567890");
			stmt.setString(2, "Poonam chand Sahu");
			stmt.setString(3, "8078785645");
			stmt.setDouble(4, 4750.0);
			stmt.setString(5, new Date(1997, 12, 24).toString());
			stmt.setString(6, "Qwerty123_");
			stmt.addBatch();
			stmt.setString(1, "SDA1234567891");
			stmt.setString(2, "Poonam test");
			stmt.setString(3, "8674787906");
			stmt.setDouble(4, 4800.0);
			stmt.setString(5, new Date(2018, 05, 05).toString());
			stmt.setString(6, "Qwerty123_");
			stmt.addBatch();
			stmt.executeBatch();
			stmt = conn.prepareStatement(queryTransaction);
			stmt.setString(1, "9e5d2938");
			stmt.setString(2, new Date().toString());
			stmt.setString(3, "SDA1234567890");
			stmt.setString(4, "SDA1234567891");
			stmt.setDouble(5, 250.0);
			stmt.setDouble(6, 4750.0);
			stmt.setString(7, "fund transfer");
			stmt.addBatch();
			stmt.executeBatch();
			stmt.setString(1, "9e5d2934");
			stmt.setString(2, new Date().toString());
			stmt.setString(3, "SDA1234567891");
			stmt.setNull(4, java.sql.Types.VARCHAR);
			stmt.setDouble(5, 750.0);
			stmt.setDouble(6, 4500.0);
			stmt.setString(7, "withdraw");
			stmt.addBatch();
			stmt.executeBatch();
			stmt.setString(1, "9e5d2904");
			stmt.setString(2, new Date().toString());
			stmt.setString(3, "SDA1234567891");
			stmt.setNull(4, java.sql.Types.VARCHAR);
			stmt.setDouble(5, 300.0);
			stmt.setDouble(6, 4800.0);
			stmt.setString(7, "deposit");
			stmt.addBatch();
			stmt.executeBatch();
			conn.close();
		} catch (Exception e) {

		}
	}

	public static Map<String, Transaction> getTransactions(String accountNum)
			throws ClassNotFoundException, SQLException, ParseException {
		Connection conn = WalletDB.getConnection();
		Statement stmt = conn.createStatement();
		Map<String, Transaction> trans = new HashMap<String, Transaction>();
		String query = "select * from bank_wallet_transaction where accfrom=\'" + accountNum + "\'";
		ResultSet rs = stmt.executeQuery(query);
		Transaction t1 = new Transaction();
		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");

		while (rs.next()) {
			t1.setAccountFrom(rs.getString(3));
			t1.setAccountTo(rs.getString(4));
			t1.setAmount(rs.getDouble(5));
			t1.setId(rs.getString(1));
			t1.setRemark(rs.getString(7));
			System.out.println(rs.getString(2));
			t1.setTime(formatter.parse(rs.getString(2)));
			trans.put(rs.getString(1), t1);
		}

		return trans;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		test();
		Map<String, Transaction> trans = getTransactions("SDA1234567891");
		Set<Entry<String, Transaction>> s = trans.entrySet();
		s.stream().forEach((e) -> System.out.println(e.getValue()));
	}

}
