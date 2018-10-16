import sys

def get_max_r(string):
	dynamic_arr = [[0]*len(string) for i in range(len(string))]

	max_r = 0

	last_r = -1
	last_k = -1

	for i in range(len(dynamic_arr)):
		last_k = -1
		last_r = -1
		for j in range(len(dynamic_arr)):
			if j<i:
				if string[j] == 'R':
					if j==0:
						dynamic_arr[i][j] = 1
					else:
						dynamic_arr[i][j] = dynamic_arr[i][j-1] + 1
				else:
					if j==0:
						dynamic_arr[i][j] = 0
					else:
						dynamic_arr[i][j] = dynamic_arr[i][j-1]
			else:
				if j==i:
					if j==0:
						if string[0] == 'R':
							dynamic_arr[0][0] = 0
							last_r = 0
						else:
							dynamic_arr[0][0] = 1
							last_k = 0
						if max_r<dynamic_arr[i][j]:
							max_r = dynamic_arr[i][j]
						continue
					if string[j] == 'K':
						dynamic_arr[i][j] = dynamic_arr[i][j-1] + 1
						last_k = j
					else:
						dynamic_arr[i][j] = dynamic_arr[i][j-1]
						last_r = j
					if max_r<dynamic_arr[i][j]:
						max_r = dynamic_arr[i][j]
					continue
				if string[j] == 'K':
					if j!=0:
						if last_k != -1:
							dynamic_arr[i][j] = max(dynamic_arr[i][j-1], dynamic_arr[i][last_k] + 1)
						else:
							dynamic_arr[i][j] = max(dynamic_arr[i][j-1], 1)
					else:
						dynamic_arr[i][j] = 1
					last_k = j
				else:
					if j!=0:
						dynamic_arr[i][j] = dynamic_arr[i][j-1] + 1
					else:
						dynamic_arr[i][j] = 1
					last_r = j
				if max_r<dynamic_arr[i][j]:
					max_r = dynamic_arr[i][j]

	# for i in range(len(dynamic_arr)):
	# 	for j in range(len(dynamic_arr)):
	# 		sys.stdout.write(str(dynamic_arr[i][j]) + "\t")
	# 	print

	print(max_r)

if __name__ == '__main__':
	t = int(input())
	for i in range(t):
		string = raw_input()
		get_max_r(string)