x=1:0.01:20;

%Manhattan Distance
x_m_notN=[1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	30	50	100];
y_m_notN=[0.24	0.233	0.217	0.212	0.206	0.205	0.339	0.332	0.311	0.297	0.335	0.333	0.34	0.29	0.318	0.33	0.307	0.318	0.354	0.337	0.32	0.334	0.349];
plot(x_m_notN, y_m_notN, 'b.--');
hold on
f_m_notN=fittype('a*log2(x)+b');
fit1=fit(x_m_notN', y_m_notN', f_m_notN', 'StartPoint', [x_m_notN(1) y_m_notN(1)]);
y1=feval(fit1, x');
plot(x, y1, 'b');

x_m_N=[1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	30	50	100];
y_m_N=[0.1	0.11	0.144	0.136	0.147	0.138	0.256	0.241	0.271	0.274	0.278	0.257	0.279	0.287	0.313	0.288	0.293	0.281	0.312	0.308	0.3	0.292	0.297];
plot(x_m_N, y_m_N, 'm.--');
hold on
f_m_N=fittype('a*log2(x)+b');
fit2=fit(x_m_N', y_m_N', f_m_N', 'StartPoint', [x_m_N(1) y_m_N(1)]);
y2=feval(fit2, x');
plot(x, y2, 'm');

%general settings
xlabel('k');
ylabel('error rate');
legend('notN_md', 'Not Normalized Manhattan Distance', 'N_md', 'Normalized Manhattan Distance');
title('Manhattan Distance Compare');