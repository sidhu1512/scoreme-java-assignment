public class Task4 {
 
    private DataSource dataSource;
 
    public List<ReportEntry> fetchMonthlyReport(String accountId,
                                                  int month, int year)
                                                  throws SQLException {

        // FIX: Implemented nested try-with-resources, fix resource leak.
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                 "SELECT * FROM report_entries " +
                 "WHERE account_id = ? AND MONTH(entry_date) = ? " +
                 "AND YEAR(entry_date) = ?"
             )) {
            
            ps.setString(1, accountId);
            ps.setInt(2, month);
            ps.setInt(3, year);
            
            // FIX: try-with-resources for ResultSet closure
            try (ResultSet rs = ps.executeQuery()) {
                List<ReportEntry> entries = new ArrayList<>();
                while (rs.next()) {
                    entries.add(mapRow(rs));
                }
            }
        }
        return entries;    
    }
}