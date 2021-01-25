package com.ersapp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ersapp.model.AllTickets;
import com.ersapp.model.ExpenseTicket;
import com.ersapp.model.ViewTicket;
import com.ersapp.util.ConnectionFactory;

public class ExpenseTicketDAOImpl implements ExpenseTicketDAO {

	@Override
	public void createTicket(ExpenseTicket ticket) {

		String sql = "INSERT INTO expense_ticket (ticket_date, expense_type, ticket_status, expense_date, expense_description, "
				+ "expense_amount, attachment, requester_id, submit_date, result_date) "
				+ "VALUES (current_date, ?, ?, ?, ?, ?, ?, ?, current_date, current_date)";
		
		try (Connection conn = ConnectionFactory.getConnection()) {
	
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticket.getExpenseType());
			ps.setInt(2, ticket.getTicketStatus());
			ps.setDate(3, Date.valueOf(ticket.getExpenseDate()));
			ps.setString(4, ticket.getExpenseDescription());
			ps.setDouble(5, ticket.getExpenseAmount());
			ps.setBytes(6, ticket.getAttachment());
			ps.setInt(7, ticket.getRequesterId());			
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Set<AllTickets> employeeTicketsView(Integer employeeId) {
		
		Set<AllTickets> empTickets = new HashSet<>();
		
		String sql = "SELECT * FROM all_tickets_view WHERE all_tickets_view.requester_id = ? ORDER BY ticket_id";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				empTickets.add(new AllTickets(
						rs.getInt("ticket_id"), 
						rs.getInt("requester_id"), 
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("role_id"), 
						rs.getString("type_name"),
						rs.getString("status_name"),
						rs.getDouble("expense_amount"),
						rs.getDate("ticket_date").toLocalDate(),
						rs.getDate("submit_date").toLocalDate(),
						rs.getBytes("attachment"),
						rs.getDate("result_date").toLocalDate(),
						rs.getString("result_comment"),
						rs.getString("expense_description"),
						rs.getDate("expense_date").toLocalDate()));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}

		return empTickets;
		
	}

	@Override
	public Set<AllTickets> managerTicketsView(Integer roleId) {
		
		Set<AllTickets> mgrTickets = new HashSet<>();
		
		String sql = "SELECT * FROM all_tickets_view WHERE all_tickets_view.role_id >= ? ORDER BY ticket_id";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				mgrTickets.add(new AllTickets(
						rs.getInt("ticket_id"), 
						rs.getInt("requester_id"), 
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("role_id"), 
						rs.getString("type_name"),
						rs.getString("status_name"),
						rs.getDouble("expense_amount"),
						rs.getDate("ticket_date").toLocalDate(),
						rs.getDate("submit_date").toLocalDate(),
						rs.getBytes("attachment"),
						rs.getDate("result_date").toLocalDate(),
						rs.getString("result_comment"),
						rs.getString("expense_description"),
						rs.getDate("expense_date").toLocalDate()));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}

		return mgrTickets;
		
	}

	@Override
	public Set<AllTickets> statusTicketsView(Integer roleId, String statusName) {
		
		Set<AllTickets> statTickets = new HashSet<>();
		
		String sql = "SELECT * FROM all_tickets_view WHERE all_tickets_view.role_id >= ? AND status_name = ? ORDER BY ticket_id";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			ps.setString(2, statusName);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				statTickets.add(new AllTickets(
						rs.getInt("ticket_id"), 
						rs.getInt("requester_id"), 
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("role_id"), 
						rs.getString("type_name"),
						rs.getString("status_name"),
						rs.getDouble("expense_amount"),
						rs.getDate("ticket_date").toLocalDate(),
						rs.getDate("submit_date").toLocalDate(),
						rs.getBytes("attachment"),
						rs.getDate("result_date").toLocalDate(),
						rs.getString("result_comment"),
						rs.getString("expense_description"),
						rs.getDate("expense_date").toLocalDate()));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}

		return statTickets;
		
	}

	@Override
	public ViewTicket getTicketById(Integer ticketId) {
		
		ViewTicket vTicket = null;
		
		String sql = "SELECT * FROM ticket_view WHERE ticket_view.ticket_id = ?";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticketId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rs.getInt("ticket_id");
			
				vTicket = new ViewTicket(
						rs.getInt("ticket_id"), 
						rs.getDate("ticket_date").toLocalDate(), 
						rs.getInt("expense_type"),
						rs.getInt("ticket_status"),
						rs.getDate("expense_date").toLocalDate(),
						rs.getString("expense_description"),
						rs.getDouble("expense_amount"),
						rs.getDate("submit_date").toLocalDate(),
						rs.getBytes("attachment"),
						rs.getDate("result_date").toLocalDate(),
						rs.getString("result_comment"),
						rs.getInt("requester_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("type_name"),
						rs.getString("status_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}

		return vTicket;
		
	}

	@Override
	public void updateTicket(ExpenseTicket ticket) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE expense_ticket SET expense_type = ?, ticket_status = ?, expense_date = ?, "
						+ "expense_description = ?, expense_amount = ?, attachment = ? "
						+ "WHERE ticket_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticket.getExpenseType());
			ps.setInt(2, ticket.getTicketStatus());
			ps.setDate(3, Date.valueOf(ticket.getExpenseDate()));
			ps.setString(4, ticket.getExpenseDescription());
			ps.setDouble(5, ticket.getExpenseAmount());
			ps.setBytes(6, ticket.getAttachment());
			ps.setInt(7, ticket.getTicketId());
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void approveTicket(Integer ticketId, Integer statusId, String resultComment) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "CALL approve_ticket(?, ?, ?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, ticketId);
			cs.setInt(2, statusId);
			cs.setString(3, resultComment);
			
			cs.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void submitTicket(Integer ticketId) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "CALL submit_ticket(?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, ticketId);
			
			cs.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTicket(Integer ticketId) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "DELETE FROM expense_ticket WHERE ticket_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticketId);
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
