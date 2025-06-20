# UNFINISHED

This is a mess and not ready yet, but I'm pushing it because it has a
bizarre ability to reproduce a kernel bug.

```
while :; do git clean -dffxq; time BB_NUMBER_THREADS="48" PARALLEL_MAKE="-j 36" ../kas/run-kas build kas/walnascar.yaml -- -k; done
```
