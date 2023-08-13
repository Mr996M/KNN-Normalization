x=1:0.01:20;

%Euclidean Distance
x_e_notN=[1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	30	50	100];
y_e_notN=[0.25	0.244	0.233	0.227	0.218	0.215	0.35	0.308	0.311	0.283	0.343	0.317	0.338	0.305	0.336	0.329	0.325	0.32	0.332	0.358	0.345	0.358	0.367];
plot(x_e_notN, y_e_notN, 'b.--');
hold on
f_e_notN=fittype('a*log2(x)+b');
fit1=fit(x_e_notN', y_e_notN', f_e_notN', 'StartPoint', [x_e_notN(1) y_e_notN(1)]);
y1=feval(fit1, x');
plot(x, y1, 'b');

x_e_N=[1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	30	50	100];
y_e_N=[0.1	0.127	0.159	0.145	0.148	0.146	0.249	0.272	0.291	0.272	0.292	0.302	0.324	0.296	0.359	0.327	0.329	0.326	0.359	0.342	0.336	0.367	0.364];
plot(x_e_N, y_e_N, 'm.--');
hold on
f_e_N=fittype('a*log2(x)+b');
fit2=fit(x_e_N', y_e_N', f_e_N', 'StartPoint', [x_e_N(1) y_e_N(1)]);
y2=feval(fit2, x');
plot(x, y2, 'm');

%general settings
xlabel('k');
ylabel('error rate');
legend('notN_ed', 'Not Normalized Euclidean Distance', 'N_ed', 'Normalized Euclidean Distance');
title('Euclidean Distance Compare');