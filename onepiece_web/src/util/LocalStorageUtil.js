const LocalStorageUtil = {
    get(key) {
        if (!key) {
            return null
        }
        key = key.toString();
        const data = window.localStorage.getItem(key);
        return JSON.parse(data);
    },
    set(key, value) {
        if (!key || !value) {
            return null
        }
        key = key.toString();
        window.localStorage.setItem(key, JSON.stringify(value));
    },
    deleteKey(key: string) {
        if (!key) {
            return;
        }
        key = key.toString();
        window.localStorage.removeItem(key);
    },
    clear() {
        window.localStorage.clear();
    }

}

export default LocalStorageUtil;