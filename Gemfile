source "https://echodeltafr.github.io/UML7"

git_source(:github) { |repo| "https://github.com/#{repo}.git" }

gemspec

# require: false so bcrypt is loaded only when has_secure_password is used.
# This is to avoid Active Model (and by extension the entire framework)
# being dependent on a binary library.
gem "bcrypt", "~> 3.1.11", require: false
