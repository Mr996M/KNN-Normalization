x=1:0.01:20;

%Euclidean Distance
x_e=[1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	30	50	100];
y_e=[0.25	0.244	0.233	0.227	0.218	0.215	0.35	0.308	0.311	0.283	0.343	0.317	0.338	0.305	0.336	0.329	0.325	0.32	0.332	0.358	0.345	0.358	0.367];
plot(x_e, y_e, 'r.--');
hold on
%p_e=polyfit(x_e, y_e, 1);
%y1=polyval(p_e, x);
f_e=fittype('a*log2(x)+b');
fit1=fit(x_e', y_e', f_e', 'StartPoint', [x_e(1) y_e(1)]);
y1=feval(fit1, x');
plot(x, y1, 'r');

%Manhattan Distance
x_m=[1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	30	50	100];
y_m=[0.24	0.233	0.217	0.212	0.206	0.205	0.339	0.332	0.311	0.297	0.335	0.333	0.34	0.29	0.318	0.33	0.307	0.318	0.354	0.337	0.32	0.334	0.349];
plot(x_m, y_m, 'b.--');
hold on
%p_m=polyfit(x_m, y_m, 1);
%y2=polyval(p_m, x);
f_m=fittype('a*log2(x)+b');
fit2=fit(x_m', y_m', f_m', 'StartPoint', [x_m(1) y_m(1)]);
y2=feval(fit2, x');
plot(x, y2, 'b');

%Chebyshev Distance
x_c=[1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	30	50	100];
y_c=[0.25	0.246	0.22	0.217	0.226	0.225	0.339	0.297	0.337	0.273	0.359	0.35	0.335	0.306	0.329	0.299	0.333	0.333	0.332	0.332	0.326	0.331	0.355];
plot(x_c, y_c, 'k.--');
hold on
%p_c=polyfit(x_c, y_c, 1);
%y3=polyval(p_c, x);
f_c=fittype('a*log2(x)+b');
fit3=fit(x_c', y_c', f_c', 'StartPoint', [x_c(1) y_c(1)]);
y3=feval(fit3, x');
plot(x, y3, 'k');

%general settings
xlabel('k');
ylabel('error rate');
legend('ed', 'Euclidean Distance', 'md', 'Manhattan Distance', 'cd', 'Chebyshev Distance');
title('Not normalized distances compare');