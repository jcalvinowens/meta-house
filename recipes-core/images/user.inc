inherit extrausers

# The default user password is "house"

EXTRA_USERS_PARAMS = " \
	useradd user; \
	usermod -p '\$1\$wpiednwi\$hdN1EYk3Mq1aBtjXtAS1X1' user; \
	usermod -a -G wheel user; \
	"
