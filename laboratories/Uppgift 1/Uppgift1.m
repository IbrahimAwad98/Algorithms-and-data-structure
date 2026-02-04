n = 1:40;

T = [ ...
1 7 25 65 140 266 462 750 1155 1705 ...
2431 3367 4550 6020 7820 9996 12597 15675 19285 23485 ...
28336 33902 40250 47450 55575 64701 74907 86275 98890 112840 ...
128216 145112 163625 183855 205905 229881 255892 284050 314470 347270 ];

%% Försök 1 – polynomanpassning av olika grad
p2 = polyfit(n, T, 2);
p3 = polyfit(n, T, 3);
p4 = polyfit(n, T, 4);
p5 = polyfit(n, T, 5);

T2 = polyval(p2, n);
T3 = polyval(p3, n);
T4 = polyval(p4, n);
T5 = polyval(p5, n);

%% Figur 1 – Grad 2
figure
plot(n, T, 'ko', n, T2, 'r')
title('Polynomanpassning – grad 2')
xlabel('n')
ylabel('T(n)')
legend('T(n)', 'Grad 2')
grid on

%% Figur 2 – Grad 3
figure
plot(n, T, 'ko', n, T3, 'g')
title('Polynomanpassning – grad 3')
xlabel('n')
ylabel('T(n)')
legend('T(n)', 'Grad 3')
grid on

%% Figur 3 – Grad 4
figure
plot(n, T, 'ko', n, T4, 'b')
title('Polynomanpassning – grad 4')
xlabel('n')
ylabel('T(n)')
legend('T(n)', 'Grad 4')
grid on

%% Figur 4 – Grad 5
figure
plot(n, T, 'ko', n, T5, 'm')
title('Polynomanpassning – grad 5')
xlabel('n')
ylabel('T(n)')
legend('T(n)', 'Grad 5')
grid on

%% Försök 2 – exakt polynom av lägsta grad
p = polyfit(n, T, 4)

%% Försök 3 – koefficienter i bråkform
format rational
p

%% Testa n = 1000
n_test = 1000;
T_poly_1000 = polyval(p, n_test)
