/*
 * Vogon personal finance/expense analyzer.
 * License TBD.
 * Author: Dmitry Zolotukhin <zlogic@gmail.com>
 */
package org.zlogic.vogon.ui;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.zlogic.vogon.data.FinanceAccount;
import org.zlogic.vogon.data.FinanceData;
import org.zlogic.vogon.data.FinanceTransaction;
import org.zlogic.vogon.data.Report;
import org.zlogic.vogon.data.TransferTransaction;

/**
 * Form for viewing analytics reports
 *
 * @author Dmitry Zolotukhin
 */
public class AnalyticsViewer extends javax.swing.JPanel implements FinanceData.AccountCreatedEventListener,
		FinanceData.AccountDeletedEventListener,
		FinanceData.AccountUpdatedEventListener,
		FinanceData.TransactionCreatedEventListener,
		FinanceData.TransactionDeletedEventListener,
		FinanceData.TransactionUpdatedEventListener {

	private static final ResourceBundle messages = ResourceBundle.getBundle("org/zlogic/vogon/ui/messages");

	/**
	 * Creates new form AnalyticsViewer
	 */
	public AnalyticsViewer() {
		initComponents();
		initCustomComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelParameters = new javax.swing.JPanel();
        javax.swing.JLabel jLabelStartDate = new javax.swing.JLabel();
        javax.swing.JLabel jLabelEndDate = new javax.swing.JLabel();
        jFormattedTextFieldStartDate = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEndDate = new javax.swing.JFormattedTextField();
        jCheckBoxExpenseTransactions = new javax.swing.JCheckBox();
        jCheckBoxTransferTransactions = new javax.swing.JCheckBox();
        jCheckBoxIncomeTransactions = new javax.swing.JCheckBox();
        jScrollPaneAccounts = new javax.swing.JScrollPane();
        jTableAccounts = new javax.swing.JTable();
        jScrollPaneTags = new javax.swing.JScrollPane();
        jTableTags = new javax.swing.JTable();
        jButtonGenerateReport = new javax.swing.JButton();
        jPanelTagsReport = new javax.swing.JPanel();
        jScrollPaneTagsReport = new javax.swing.JScrollPane();
        jTableTagsReport = new javax.swing.JTable();
        jPanelTagsChart = new javax.swing.JPanel();
        jPanelTransactionsReport = new javax.swing.JPanel();
        jScrollPaneTransactionsReport = new javax.swing.JScrollPane();
        jTableTransactionsReport = new javax.swing.JTable();
        jPanelBalanceChart = new javax.swing.JPanel();

        jPanelParameters.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameters"));

        jLabelStartDate.setLabelFor(jFormattedTextFieldStartDate);
        jLabelStartDate.setText(messages.getString("START_DATE")); // NOI18N

        jLabelEndDate.setLabelFor(jFormattedTextFieldEndDate);
        jLabelEndDate.setText(messages.getString("END_DATE")); // NOI18N

        jFormattedTextFieldStartDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jFormattedTextFieldEndDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jCheckBoxExpenseTransactions.setSelected(true);
        jCheckBoxExpenseTransactions.setText(messages.getString("EXPENSE_TRANSACTIONS")); // NOI18N

        jCheckBoxTransferTransactions.setText(messages.getString("TRANSFER_TRANSACTIONS")); // NOI18N

        jCheckBoxIncomeTransactions.setSelected(true);
        jCheckBoxIncomeTransactions.setText(messages.getString("INCOME_TRANSACTIONS")); // NOI18N

        jTableAccounts.setModel(getAccountsSelectionTableModel());
        jTableAccounts.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPaneAccounts.setViewportView(jTableAccounts);

        jTableTags.setModel(getTagsSelectionTableModel());
        jTableTags.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPaneTags.setViewportView(jTableTags);

        javax.swing.GroupLayout jPanelParametersLayout = new javax.swing.GroupLayout(jPanelParameters);
        jPanelParameters.setLayout(jPanelParametersLayout);
        jPanelParametersLayout.setHorizontalGroup(
            jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParametersLayout.createSequentialGroup()
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelParametersLayout.createSequentialGroup()
                        .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelStartDate)
                            .addComponent(jLabelEndDate))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jFormattedTextFieldStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldEndDate)))
                    .addComponent(jCheckBoxTransferTransactions)
                    .addComponent(jCheckBoxExpenseTransactions)
                    .addComponent(jCheckBoxIncomeTransactions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTags, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanelParametersLayout.setVerticalGroup(
            jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParametersLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPaneTags, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPaneAccounts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelParametersLayout.createSequentialGroup()
                        .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStartDate)
                            .addComponent(jFormattedTextFieldStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEndDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxTransferTransactions)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxExpenseTransactions)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxIncomeTransactions))))
        );

        jButtonGenerateReport.setText(messages.getString("GENERATE_REPORT")); // NOI18N
        jButtonGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateReportActionPerformed(evt);
            }
        });

        jPanelTagsReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Statistics by tags"));

        jTableTagsReport.setAutoCreateRowSorter(true);
        jTableTagsReport.setModel(getTagsReportTableModel());
        jTableTagsReport.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPaneTagsReport.setViewportView(jTableTagsReport);

        jPanelTagsChart.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanelTagsReportLayout = new javax.swing.GroupLayout(jPanelTagsReport);
        jPanelTagsReport.setLayout(jPanelTagsReportLayout);
        jPanelTagsReportLayout.setHorizontalGroup(
            jPanelTagsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTagsReportLayout.createSequentialGroup()
                .addComponent(jScrollPaneTagsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTagsChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTagsReportLayout.setVerticalGroup(
            jPanelTagsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTagsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanelTagsChart, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        jPanelTransactionsReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Transactions"));

        jTableTransactionsReport.setAutoCreateRowSorter(true);
        jTableTransactionsReport.setModel(getTransactionsReportTableModel());
        jTableTransactionsReport.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPaneTransactionsReport.setViewportView(jTableTransactionsReport);

        jPanelBalanceChart.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanelTransactionsReportLayout = new javax.swing.GroupLayout(jPanelTransactionsReport);
        jPanelTransactionsReport.setLayout(jPanelTransactionsReportLayout);
        jPanelTransactionsReportLayout.setHorizontalGroup(
            jPanelTransactionsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTransactionsReportLayout.createSequentialGroup()
                .addComponent(jScrollPaneTransactionsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBalanceChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTransactionsReportLayout.setVerticalGroup(
            jPanelTransactionsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTransactionsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanelBalanceChart, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonGenerateReport)
                .addGap(573, 604, Short.MAX_VALUE))
            .addComponent(jPanelParameters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTagsReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTransactionsReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGenerateReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTagsReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTransactionsReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateReportActionPerformed
		//Assign report settings
		DateFormat dateFormat = new SimpleDateFormat(messages.getString("PARSER_DATE"));
		try {
			report.setEarliestDate(dateFormat.parse(jFormattedTextFieldStartDate.getText()));
			report.setLatestDate(dateFormat.parse(jFormattedTextFieldEndDate.getText()));
			report.setEnabledExpenseTransactions(jCheckBoxExpenseTransactions.isSelected());
			report.setEnabledTransferTransactions(jCheckBoxTransferTransactions.isSelected());
			report.setEnabledIncomeTransactions(jCheckBoxIncomeTransactions.isSelected());

			DefaultTableModel tagsModel = (DefaultTableModel) jTableTags.getModel();
			List<String> tags = new LinkedList<>();
			for (int i = 0; i < tagsModel.getRowCount(); i++)
				if (tagsModel.getValueAt(i, 1) instanceof Boolean && (Boolean) tagsModel.getValueAt(i, 1))
					tags.add((String) tagsModel.getValueAt(i, 0));
			report.setSelectedTags(tags);

			DefaultTableModel accountsModel = (DefaultTableModel) jTableAccounts.getModel();
			List<FinanceAccount> accounts = new LinkedList<>();
			for (int i = 0; i < accountsModel.getRowCount(); i++)
				if (accountsModel.getValueAt(i, 1) instanceof Boolean && (Boolean) accountsModel.getValueAt(i, 1))
					accounts.add(((AccountDisplay) accountsModel.getValueAt(i, 0)).getAccount());
			report.setSelectedAccounts(accounts);
		} catch (ParseException ex) {
			Logger.getLogger(AnalyticsViewer.class.getName()).log(Level.SEVERE, null, ex);
		}
		//Update form with report
		updateTagsChart(report.getTagExpenses());
		updateTagsReportTable(report.getTagExpenses());
		updateBalanceChart(report.getAccountsBalanceGraph());
		updateTransactionsReportTable(report.getTransactions());
    }//GEN-LAST:event_jButtonGenerateReportActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGenerateReport;
    private javax.swing.JCheckBox jCheckBoxExpenseTransactions;
    private javax.swing.JCheckBox jCheckBoxIncomeTransactions;
    private javax.swing.JCheckBox jCheckBoxTransferTransactions;
    private javax.swing.JFormattedTextField jFormattedTextFieldEndDate;
    private javax.swing.JFormattedTextField jFormattedTextFieldStartDate;
    private javax.swing.JPanel jPanelBalanceChart;
    private javax.swing.JPanel jPanelParameters;
    private javax.swing.JPanel jPanelTagsChart;
    private javax.swing.JPanel jPanelTagsReport;
    private javax.swing.JPanel jPanelTransactionsReport;
    private javax.swing.JScrollPane jScrollPaneAccounts;
    private javax.swing.JScrollPane jScrollPaneTags;
    private javax.swing.JScrollPane jScrollPaneTagsReport;
    private javax.swing.JScrollPane jScrollPaneTransactionsReport;
    private javax.swing.JTable jTableAccounts;
    private javax.swing.JTable jTableTags;
    private javax.swing.JTable jTableTagsReport;
    private javax.swing.JTable jTableTransactionsReport;
    // End of variables declaration//GEN-END:variables

	/**
	 * Sets the FinanceDate to generate the report
	 *
	 * @param financeData the finance data to generate the report
	 */
	public void setFinanceData(FinanceData financeData) {
		this.financeData = financeData;
		report = new Report(financeData);
		financeData.addAccountCreatedListener(this);
		financeData.addAccountDeletedListener(this);
		financeData.addAccountUpdatedListener(this);
		financeData.addTransactionCreatedListener(this);
		financeData.addTransactionDeletedListener(this);
		financeData.addTransactionUpdatedListener(this);
		resetForm();
	}

	/**
	 * Completes user configuration of form
	 */
	private void initCustomComponents() {
		jTableTags.getColumnModel().getColumn(1).setMinWidth(30);
		jTableTags.getColumnModel().getColumn(1).setMaxWidth(100);
		jTableTags.getColumnModel().getColumn(1).setPreferredWidth(50);
		jTableAccounts.getColumnModel().getColumn(1).setMinWidth(30);
		jTableAccounts.getColumnModel().getColumn(1).setMaxWidth(100);
		jTableAccounts.getColumnModel().getColumn(1).setPreferredWidth(50);
		jTableTagsReport.getColumnModel().getColumn(1).setCellRenderer(SumTableCell.getRenderer());
		jTableTransactionsReport.getColumnModel().getColumn(2).setCellRenderer(SumTableCell.getRenderer());
		//jTableTagsReport.getRowSorter().toggleSortOrder(1);
	}

	/**
	 * Resets all fields to their default values
	 */
	public void resetForm() {
		DateFormat format = new SimpleDateFormat(messages.getString("PARSER_DATE"));
		jFormattedTextFieldStartDate.setText(format.format(report.getEarliestDate()));
		jFormattedTextFieldEndDate.setText(format.format(report.getLatestDate()));

		//Set tags
		DefaultTableModel tagsModel = (DefaultTableModel) jTableTags.getModel();
		while (tagsModel.getRowCount() > 0)
			tagsModel.removeRow(0);
		for (String tag : report.getAllTags())
			tagsModel.addRow(new Object[]{tag, new Boolean(true)});

		//Set accounts
		DefaultTableModel accountsModel = (DefaultTableModel) jTableAccounts.getModel();
		while (accountsModel.getRowCount() > 0)
			accountsModel.removeRow(0);
		for (FinanceAccount account : report.getAllAccounts())
			accountsModel.addRow(new Object[]{new AccountDisplay(account), account.getIncludeInTotal()});
	}

	/**
	 * Updates the tags pie chart
	 *
	 * @param values expenses grouped by tag
	 */
	private void updateTagsChart(Map<String, Double> values) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Map.Entry<String, Double> tagExpense : values.entrySet())
			dataset.setValue(tagExpense.getKey(), Math.abs(tagExpense.getValue()));

		JFreeChart chart = ChartFactory.createPieChart3D("", dataset, false, true, false);
		chart.setBackgroundPaint(jPanelTagsChart.getBackground());

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setForegroundAlpha(0.5f);
		plot.setBackgroundPaint(jPanelTagsChart.getBackground());

		ChartPanel chartPanel = new ChartPanel(chart);
		jPanelTagsChart.removeAll();
		jPanelTagsChart.add(chartPanel);
		jPanelTagsChart.revalidate();
	}

	/**
	 * Updates the tags reporting table
	 *
	 * @param values expenses grouped by tag
	 */
	private void updateTagsReportTable(Map<String, Double> values) {
		DefaultTableModel tableModel = (DefaultTableModel) jTableTagsReport.getModel();
		while (tableModel.getRowCount() > 0)
			tableModel.removeRow(0);
		for (Map.Entry<String, Double> tagExpense : values.entrySet())
			tableModel.addRow(new Object[]{tagExpense.getKey(), new SumTableCell(tagExpense.getValue(), true, financeData.getDefaultCurrency(), true, false)});
	}

	/**
	 * Updates the balance chart
	 *
	 * @param values expenses grouped by tag
	 */
	private void updateBalanceChart(Map<Date, Double> values) {
		TimeSeries balanceSeries = new TimeSeries(messages.getString("TOTAL_BALANCE"));
		for (Map.Entry<Date, Double> balance : values.entrySet())
			balanceSeries.add(new Day(balance.getKey()), balance.getValue());

		JFreeChart chart = ChartFactory.createTimeSeriesChart("", "", "", new TimeSeriesCollection(balanceSeries), false, true, false);
		chart.setBackgroundPaint(jPanelTagsChart.getBackground());

		XYPlot plot = (XYPlot) chart.getPlot();
		//XYSplineRenderer renderer = new XYSplineRenderer();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, true);
		renderer.setBaseToolTipGenerator(((XYLineAndShapeRenderer) plot.getRenderer()).getBaseToolTipGenerator());
		plot.setRenderer(renderer);
		plot.setForegroundAlpha(0.5f);
		plot.setBackgroundPaint(jPanelTagsChart.getBackground());

		ChartPanel chartPanel = new ChartPanel(chart);
		jPanelBalanceChart.removeAll();
		jPanelBalanceChart.add(chartPanel);
		jPanelBalanceChart.revalidate();
	}

	/**
	 * Updates the transactions reporting table
	 *
	 * @param values expenses grouped by tag
	 */
	private void updateTransactionsReportTable(List<FinanceTransaction> transactions) {
		DefaultTableModel tableModel = (DefaultTableModel) jTableTransactionsReport.getModel();
		while (tableModel.getRowCount() > 0)
			tableModel.removeRow(0);
		for (FinanceTransaction transaction : transactions) {
			List<Currency> transactionCurrencies = transaction.getCurrencies();
			Currency currency;
			double amount;
			if (transactionCurrencies.size() == 1) {
				amount = transaction.getAmount();
				currency = transactionCurrencies.get(0);
			} else {
				amount = financeData.getAmountInCurrency(transaction, financeData.getDefaultCurrency());
				currency = financeData.getDefaultCurrency();
			}
			tableModel.addRow(new Object[]{transaction.getDescription(),
						MessageFormat.format(messages.getString("FORMAT_DATE"), new Object[]{transaction.getDate()}),
						new SumTableCell(
						transaction.getAmount(),
						true,
						financeData.getDefaultCurrency(),
						transactionCurrencies.size() != 1,
						transaction instanceof TransferTransaction)});
		}
	}

	/**
	 * Table model for accounts selection table
	 *
	 * @return the model for accounts selection table
	 */
	private TableModel getAccountsSelectionTableModel() {
		return new javax.swing.table.DefaultTableModel(
				new Object[][]{},
				new String[]{
					messages.getString("ACCOUNT_NAME"), messages.getString("SHOW")
				}) {
			Class[] types = new Class[]{
				java.lang.Object.class, java.lang.Boolean.class
			};

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return getColumnClass(column).equals(Boolean.class);
			}
		};
	}

	/**
	 * Table model for tags selection table
	 *
	 * @return the model for tags selection table
	 */
	private TableModel getTagsSelectionTableModel() {
		return new javax.swing.table.DefaultTableModel(
				new Object[][]{},
				new String[]{
					messages.getString("TAG_NAME"), messages.getString("SHOW")
				}) {
			Class[] types = new Class[]{
				java.lang.String.class, java.lang.Boolean.class
			};

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return getColumnClass(column).equals(Boolean.class);
			}
		};
	}

	/**
	 * Table model for tags report/statistics
	 *
	 * @return the model for tags report/statistics table
	 */
	private TableModel getTagsReportTableModel() {
		return new javax.swing.table.DefaultTableModel(
				new Object[][]{},
				new String[]{
					messages.getString("TAG_NAME"), messages.getString("TRANSACTION_AMOUNT")
				}) {
			Class[] types = new Class[]{
				java.lang.String.class, SumTableCell.class
			};

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

	/**
	 * Table model for transactions report
	 *
	 * @return the model for transactions report table
	 */
	private TableModel getTransactionsReportTableModel() {
		return new javax.swing.table.DefaultTableModel(
				new Object[][]{},
				new String[]{
					messages.getString("TRANSACTION_NAME"), messages.getString("TRANSACTION_DATE"), messages.getString("TRANSACTION_AMOUNT")
				}) {
			Class[] types = new Class[]{
				java.lang.String.class, java.lang.String.class, SumTableCell.class
			};

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

	@Override
	public void accountCreated(FinanceAccount newAccount) {
		resetForm();
	}

	@Override
	public void accountDeleted(FinanceAccount deletedAccount) {
		resetForm();
	}

	@Override
	public void accountUpdated(FinanceAccount updatedAccount) {
		resetForm();
	}

	@Override
	public void accountsUpdated() {
		resetForm();
	}

	@Override
	public void transactionCreated(FinanceTransaction newTransaction) {
		resetForm();
	}

	@Override
	public void transactionDeleted(FinanceTransaction deletedTransaction) {
		resetForm();
	}

	@Override
	public void transactionUpdated(FinanceTransaction updatedTransaction) {
		resetForm();
	}

	@Override
	public void transactionsUpdated() {
		resetForm();
	}

	/**
	 * Class for displaying an account in a table
	 */
	private class AccountDisplay {

		protected FinanceAccount account;

		public AccountDisplay(FinanceAccount account) {
			this.account = account;
		}

		public FinanceAccount getAccount() {
			return account;
		}

		@Override
		public String toString() {
			return account.getName();
		}
	}
	/**
	 * The report generator
	 */
	protected Report report;
	/**
	 * The finance data reference
	 */
	protected FinanceData financeData;
}
