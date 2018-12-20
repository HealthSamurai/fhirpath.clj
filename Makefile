repl:
	clj -A:test:nrepl -e "(-main)" -r

test:
	clj -A:test:runner
