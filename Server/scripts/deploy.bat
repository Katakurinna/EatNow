:: EatNow deploy file for windows clients.
cd target
echo put server-1.0.jar | sftp -i ~/.ssh/virtualbox_unix_key katakurinna@192.168.0.30:server
echo ./server-restart-script.sh | ssh -i ~/.ssh/virtualbox_unix_key katakurinna@192.168.0.30