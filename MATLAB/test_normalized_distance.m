x=1:0.01:20;

%Euclidean Distance
x_e=[1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	30	50	100];
y_e=[0.1	0.127	0.159	0.145	0.148	0.146	0.249	0.272	0.291	0.272	0.292	0.302	0.324	0.296	0.359	0.327	0.329	0.326	0.359	0.342	0.336	0.367	0.364];
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
y_m=[0.1	0.11	0.144	0.136	0.147	0.138	0.256	0.241	0.271	0.274	0.278	0.257	0.279	0.287	0.313	0.288	0.293	0.281	0.312	0.308	0.3	0.292	0.297];
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
y_c=[0.1	0.129	0.165	0.164	0.154	0.164	0.288	0.279	0.314	0.291	0.325	0.305	0.33	0.361	0.364	0.37	0.363	0.375	0.395	0.406	0.403	0.423	0.441];
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
title('Normalized distances compare');