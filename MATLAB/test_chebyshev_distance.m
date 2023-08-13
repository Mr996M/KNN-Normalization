x=1:0.01:20;

%Chebyshev Distance
x_c_notN=[1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	30	50	100];
y_c_notN=[0.25	0.246	0.22	0.217	0.226	0.225	0.339	0.297	0.337	0.273	0.359	0.35	0.335	0.306	0.329	0.299	0.333	0.333	0.332	0.332	0.326	0.331	0.355];
plot(x_c_notN, y_c_notN, 'b.--');
hold on
f_c_notN=fittype('a*log2(x)+b');
fit1=fit(x_c_notN', y_c_notN', f_c_notN', 'StartPoint', [x_c_notN(1) y_c_notN(1)]);
y1=feval(fit1, x');
plot(x, y1, 'b');

x_c_N=[1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	30	50	100];
y_c_N=[0.1	0.129	0.165	0.164	0.154	0.164	0.288	0.279	0.314	0.291	0.325	0.305	0.33	0.361	0.364	0.37	0.363	0.375	0.395	0.406	0.403	0.423	0.441];
plot(x_c_N, y_c_N, 'm.--');
hold on
f_c_N=fittype('a*log2(x)+b');
fit2=fit(x_c_N', y_c_N', f_c_N', 'StartPoint', [x_c_N(1) y_c_N(1)]);
y2=feval(fit2, x');
plot(x, y2, 'm');

%general settings
xlabel('k');
ylabel('error rate');
legend('notN_cd', 'Not Normalized Chebyshev Distance', 'N_cd', 'Normalized Chebyshev Distance');
title('Chebyshev Distance Compare');